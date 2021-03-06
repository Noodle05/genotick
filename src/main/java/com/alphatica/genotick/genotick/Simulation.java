package com.alphatica.genotick.genotick;

import com.alphatica.genotick.breeder.BreederSettings;
import com.alphatica.genotick.breeder.RobotBreeder;
import com.alphatica.genotick.breeder.RobotBreederFactory;
import com.alphatica.genotick.data.MainAppData;
import com.alphatica.genotick.killer.RobotKiller;
import com.alphatica.genotick.killer.RobotKillerFactory;
import com.alphatica.genotick.killer.RobotKillerSettings;
import com.alphatica.genotick.mutator.Mutator;
import com.alphatica.genotick.mutator.MutatorFactory;
import com.alphatica.genotick.mutator.MutatorSettings;
import com.alphatica.genotick.population.Population;
import com.alphatica.genotick.population.PopulationDAO;
import com.alphatica.genotick.population.PopulationDAOFactory;
import com.alphatica.genotick.population.RobotExecutorSettings;
import com.alphatica.genotick.processor.RobotExecutorFactory;
import com.alphatica.genotick.timepoint.TimePointExecutor;
import com.alphatica.genotick.timepoint.TimePointExecutorFactory;
import com.alphatica.genotick.ui.UserInputOutputFactory;
import com.alphatica.genotick.ui.UserOutput;

public class Simulation {
    private final UserOutput output = UserInputOutputFactory.getUserOutput();
    private Population population;

    @SuppressWarnings("WeakerAccess")
    public Simulation() {
    }


    public void start(MainSettings mainSettings, MainAppData data) throws IllegalAccessException {
        if(validateSettings(mainSettings)) {
            logSettings(mainSettings);
            RobotKiller killer = getRobotKiller(mainSettings);
            Mutator mutator = getMutator(mainSettings);
            RobotBreeder breeder = wireBreeder(mainSettings, mutator);
            population = wirePopulation(mainSettings);
            Engine engine = wireEngine(mainSettings, data, killer, breeder, population);
            engine.start();
        }
    }

    public Population getPopulation() {
        return population;
    }

    private boolean validateSettings(MainSettings settings) {
        try {
            settings.validate();
            return true;
        } catch(IllegalArgumentException ex) {
            ex.printStackTrace();
            output.errorMessage(ex.getMessage());
            return false;
        }
    }

    private Engine wireEngine(MainSettings mainSettings, MainAppData data, RobotKiller killer,
                              RobotBreeder breeder, Population population) {
        EngineSettings engineSettings = getEngineSettings(mainSettings);
        TimePointExecutor timePointExecutor = wireTimePointExecutor(mainSettings);
        return EngineFactory.getDefaultEngine(engineSettings, data, timePointExecutor, killer, breeder, population);
    }

    private TimePointExecutor wireTimePointExecutor(MainSettings settings) {
        DataSetExecutor dataSetExecutor = new SimpleDataSetExecutor();
        RobotExecutorSettings robotExecutorSettings = new RobotExecutorSettings(settings);
        RobotExecutorFactory robotExecutorFactory = new RobotExecutorFactory(robotExecutorSettings);
        return TimePointExecutorFactory.getDefaultExecutor(dataSetExecutor, robotExecutorFactory);
    }

    private Population wirePopulation(MainSettings settings) {
        PopulationDAO dao = PopulationDAOFactory.getDefaultDAO(settings.populationDAO);
        Population p = PopulationFactory.getDefaultPopulation(dao);
        p.setDesiredSize(settings.populationDesiredSize);
        return p;
    }

    private RobotBreeder wireBreeder(MainSettings settings, Mutator mutator) {
        BreederSettings breederSettings = new BreederSettings(
                settings.minimumOutcomesBetweenBreeding,
                settings.inheritedChildWeight,
                settings.minimumOutcomesToAllowBreeding,
                settings.randomRobotsAtEachUpdate,
                settings.dataMaximumOffset,
                settings.ignoreColumns);
        return RobotBreederFactory.getDefaultBreeder(breederSettings, mutator);
    }

    private RobotKiller getRobotKiller(MainSettings settings) {
        RobotKillerSettings killerSettings = new RobotKillerSettings();
        killerSettings.maximumDeathByAge = settings.maximumDeathByAge;
        killerSettings.maximumDeathByWeight = settings.maximumDeathByWeight;
        killerSettings.probabilityOfDeathByAge = settings.probabilityOfDeathByAge;
        killerSettings.probabilityOfDeathByWeight = settings.probabilityOfDeathByWeight;
        killerSettings.protectRobotsUntilOutcomes = settings.protectRobotsUntilOutcomes;
        killerSettings.protectBestRobots = settings.protectBestRobots;
        killerSettings.killNonPredictingRobots = settings.killNonPredictingRobots;
        killerSettings.requireSymmetricalRobots = settings.requireSymmetricalRobots;
        return RobotKillerFactory.getDefaultRobotKiller(killerSettings);
    }

    private Mutator getMutator(MainSettings settings) {
        MutatorSettings mutatorSettings = new MutatorSettings(
                settings.instructionMutationProbability,
                settings.newInstructionProbability,
                settings.skipInstructionProbability);
        return MutatorFactory.getDefaultMutator(mutatorSettings);
    }


    private EngineSettings getEngineSettings(MainSettings settings) {
        EngineSettings engineSettings = new EngineSettings();
        engineSettings.startTimePoint = settings.startTimePoint;
        engineSettings.endTimePoint = settings.endTimePoint;
        engineSettings.performTraining = settings.performTraining;
        engineSettings.resultThreshold = settings.resultThreshold;
        engineSettings.requireSymmetrical = settings.requireSymmetricalRobots;
        return engineSettings;
    }

    private void logSettings(MainSettings settings) throws IllegalAccessException {
        String settingsString = settings.getString();
        output.infoMessage(settingsString);
    }

}
