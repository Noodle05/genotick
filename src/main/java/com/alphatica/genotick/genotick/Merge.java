package com.alphatica.genotick.genotick;

import com.alphatica.genotick.population.Population;
import com.alphatica.genotick.population.PopulationDAOFileSystem;
import com.alphatica.genotick.population.PopulationSettings;
import com.alphatica.genotick.population.Robot;
import com.alphatica.genotick.population.RobotInfo;
import com.alphatica.genotick.ui.UserOutput;

import java.io.*;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

class Merge {
    private final MainSettings settings;
    private final UserOutput output;
    
    public Merge(MainSettings settings, UserOutput output) {
        this.settings = settings;
        this.output = output;
    }
    
    public ErrorCode mergePopulations(String destination, String source) throws IllegalAccessException {
        return mergePopulations(destination, source, null);
    }
    
    public ErrorCode mergePopulations(String destination, List<String> sourceList) throws IllegalAccessException {
        return mergePopulations(destination, null, sourceList);
    }

    private ErrorCode mergePopulations(String destination, String source, List<String> sourceList) throws IllegalAccessException {
        File destinationPath = new File(destination);
        destinationPath.mkdirs();
        PopulationDAOFileSystem dao = new PopulationDAOFileSystem(destinationPath.getAbsolutePath());
        Population destinationPopulation = settings == null ? 
                PopulationFactory.getDefaultPopulation(dao) : PopulationFactory.getDefaultPopulation(new PopulationSettings(settings), dao);
        List<RobotInfo> destinationRobots = destinationPopulation.getRobotInfoList();
        destinationRobots.sort(Comparator.comparing(RobotInfo::getScore));
        double initialScore = Population.populationScore(destinationRobots);
        output.infoMessage(format("Current population size: %d desiredSize: %d population score: %.4f", 
            destinationPopulation.getSize(), destinationPopulation.getDesiredSize(), initialScore));
        output.infoMessage(format("Destination path: %s", destinationPath.getAbsolutePath()));
        try { 
            if(source != null) {
                Files.walk(Paths.get(source), 1)
                    .filter(path -> Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
                    .filter(path -> !destinationPath.getAbsolutePath().equals(new File(path.toString().replace("./", "")).getAbsolutePath()))
                    .collect(Collectors.toList())
                    .parallelStream()
                    .forEach(directory -> mergeSource(settings, destinationPopulation, destinationPath.getAbsolutePath(), destinationRobots, directory));
            } 
            if(sourceList != null) {
                sourceList
                    .parallelStream()
                    .forEach(directory -> mergeSource(settings, destinationPopulation, destinationPath.getAbsolutePath(), destinationRobots, Paths.get(directory)));
            }
        } catch (IOException e) {
            // Falling through here just ignores folders with any access errors.
        }
        destinationPopulation.saveOnDisk();
        double newScore = Population.populationScore(destinationRobots);
        if(newScore > initialScore) {
            output.infoMessage(format("Success merging populations. New size: %d old score: %.4f new score: %.4f", 
                destinationPopulation.getSize(), initialScore, newScore));
            output.infoMessage(format("Final population directiory: %s", destinationPath.toString()));
            return ErrorCode.NO_ERROR;
        }
        if(newScore < initialScore) {
            output.infoMessage(format("Warning population score decreased after merge:%.4f", newScore));
        }
        return ErrorCode.NO_OUTPUT;
    }
    
    private void mergeSource(MainSettings settings, Population destinationPopulation, String destination, List<RobotInfo> destinationRobots, Path sourcePath) {
        File sourceFile = new File(sourcePath.toString().replace("./", ""));
        if(!sourceFile.exists()) {
            output.errorMessage(format("Merge soruce directory %s does not exist.", sourceFile.toString()));
            return;
        }
        String source = sourceFile.getAbsolutePath();
        PopulationDAOFileSystem daoSource = new PopulationDAOFileSystem(source);
        Population sourcePopulation = settings == null ? 
                PopulationFactory.getDefaultPopulation(daoSource) : PopulationFactory.getDefaultPopulation(new PopulationSettings(settings), daoSource);
        if(sourcePopulation.getSize() < 1) {
            return;
        }
        output.infoMessage(format("Source path: %s", source));
        List<RobotInfo> sourceRobots = sourcePopulation.getRobotInfoList();
        sourceRobots.stream()
            .filter(robot -> robot.getWeight() == 0.0)
            .collect(Collectors.toList())
            .forEach(robot -> sourcePopulation.removeRobot(robot.getName()));
        sourceRobots.sort(Comparator.comparing(RobotInfo::getScore).reversed());
        while(!sourceRobots.isEmpty()) {
            RobotInfo best = sourceRobots.remove(0);

            synchronized(destinationPopulation) {
                RobotInfo worst = destinationRobots.isEmpty() ? null : destinationRobots.get(0);
                if(moreRobotsNeeded(destinationPopulation, best, worst)) {
                    // Take robot...
                    output.infoMessage(format("Adding robot %s to destination due to desination not full. Score: %.4f new size: %d", 
                        best.getName(), best.getScore(), destinationPopulation.getSize()+1));
                    if(!moveRobot(sourcePopulation, destinationPopulation, destinationRobots, best)) {
                        return;
                    }
                } else if(betterRobotFound(destinationPopulation, best, worst)) {
                    output.infoMessage(format("Adding robot %s to destination due to higher score. Score: %.4f population score: %.4f",
                        best.getName(), best.getScore(), Population.populationScore(destinationRobots)));
                    destinationRobots.remove(0);
                    destinationPopulation.removeRobot(worst.getName());
                    if(!moveRobot(sourcePopulation, destinationPopulation, destinationRobots, best)) {
                        return;
                    }
                }
            }
        }
        try {
            Files.walk(sourceFile.toPath())
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        } catch (IOException e) {
            output.infoMessage(format("Exception clearing directory %s. Exception %s", sourceFile, e.toString()));
        }
    }
    
    private static boolean moreRobotsNeeded(Population destinationPopulation, RobotInfo best, RobotInfo worst) {
        return destinationPopulation.getSize() < destinationPopulation.getDesiredSize() 
            && best.getScore() > 0.0 
            && best.hasPredicted();
    }
    
    private static boolean betterRobotFound(Population destinationPopulation, RobotInfo best, RobotInfo worst) {
        return worst != null 
            && best.getScore() > 0 
            && worst.getScore() < best.getScore()
            && (best.hasPredicted() || !worst.hasPredicted());
    }
    
    private static boolean moveRobot(Population sourcePopulation, Population destinationPopulation, List<RobotInfo> destinationRobots, RobotInfo robot) {
        Robot movingRobot = sourcePopulation.getRobot(robot.getName());
        if(movingRobot == null) {
            return false;
        }
        sourcePopulation.removeRobot(robot.getName());
        movingRobot.setName(null);
        destinationPopulation.saveRobot(movingRobot);
        destinationRobots.add(new RobotInfo(movingRobot));
        destinationRobots.sort(Comparator.comparing(RobotInfo::getScore));
        return true;
    }
}

