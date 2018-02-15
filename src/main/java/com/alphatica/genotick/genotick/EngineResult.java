package com.alphatica.genotick.genotick;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.alphatica.genotick.population.Population;
import com.alphatica.genotick.population.Robot;
import com.alphatica.genotick.population.RobotInfo;

public class EngineResult {
    private final BigDecimal balance;
    private final int activePopulationSize;
    private final double populationScore;
    private final double worstRobotScore;
    private final double bestRobotScore;
    private final String populationDirectory;

    public EngineResult(final BigDecimal balance, final Population population, final EngineSettings engineSettings, final String populationDirectory) {
        this.balance = balance;
        
        List<RobotInfo> robotInfoList = population.getRobotInfoList().stream()
            .filter(robot -> 
                robot.getScore() >= engineSettings.minimumScoreToSaveToDisk && 
                (engineSettings.killNonPredictingRobots == 0 || robot.isPredicting(engineSettings.killNonPredictingRobots))
            )
            .collect(Collectors.toList());
        robotInfoList.sort(Comparator.comparing(RobotInfo::getScore));
        this.activePopulationSize = robotInfoList.size();
        this.populationScore = Population.populationScore(robotInfoList);
        this.worstRobotScore = robotInfoList.size() > 0 ? robotInfoList.get(0).getScore() : 0.0;
        this.bestRobotScore = robotInfoList.size() > 0 ? robotInfoList.get(robotInfoList.size()-1).getScore() : 0.0;
        this.populationDirectory = populationDirectory;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public int getActivePopulationSize() {
        return activePopulationSize;
    }
    
    public double getPopulationScore() {
        return populationScore;
    }
    
    public double getWorstRobotScore() {
        return worstRobotScore;
    }

    public double getBestRobotScore() {
        return bestRobotScore;
    }
    
    public String getPopulationDirectory() {
        return populationDirectory;
    }
}

