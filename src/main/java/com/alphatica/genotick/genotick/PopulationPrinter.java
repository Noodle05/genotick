package com.alphatica.genotick.genotick;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.alphatica.genotick.population.Population;
import com.alphatica.genotick.population.PopulationDAOFileSystem;
import com.alphatica.genotick.population.Robot;
import com.alphatica.genotick.population.RobotInfo;

class PopulationPrinter
{
    public static void printPopulation(String path, boolean printStatistics, boolean showRobots) throws IllegalAccessException {
        PopulationDAOFileSystem dao = new PopulationDAOFileSystem(path);
        Population population = PopulationFactory.getDefaultPopulation(dao);
        showHeader();
        showRobots(population, printStatistics, showRobots);
    }

    private static void showRobots(Population population, boolean printStatistics, boolean showRobots) throws IllegalAccessException {
        int countPositiveWeight = 0;
        double positiveWeight = 0.0;
        int countNegativeWeight = 0;
        double negativeWeight = 0.0;
        List<RobotInfo> robotInfoList = population.getRobotInfoList();
        for(RobotInfo robotInfo: robotInfoList) {
            String info = getRobotInfoString(robotInfo);
            System.out.println(info);
            if(robotInfo.getWeight() >= 0.0) {
                countPositiveWeight++;
                positiveWeight += robotInfo.getWeight();
            } else {
                countNegativeWeight++;
                negativeWeight += robotInfo.getWeight();
            }
            
        }
        if(printStatistics) {
            System.out.println(String.format("Statistics. Total size: %d, positive weighted: %d positive average: %f negative weighted: %d negative average: %f", 
                    population.getSize(), 
                    countPositiveWeight, positiveWeight / Math.max(1, countPositiveWeight), 
                    countNegativeWeight, negativeWeight / Math.max(1, countNegativeWeight)
            ));
        }
        
        if(showRobots) {
            for(RobotInfo robotInfo: robotInfoList) {
                Robot robot = population.getRobot(robotInfo.getName());
                System.out.println(String.format("Showing robot %s", robotInfo.getName()));
                System.out.println(robot.showRobot());
            }
        }
    }

    private static String getRobotInfoString(RobotInfo robotInfo) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        Field [] fields = robotInfo.getClass().getDeclaredFields();
        for(Field field: fields) {
            field.setAccessible(true);
            if(!Modifier.isStatic(field.getModifiers())) {
                Object object = field.get(robotInfo);
                if(sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(object.toString());
            }
        }
        return sb.toString();
    }

    private static void showHeader() {
        Class<RobotInfo> infoClass = RobotInfo.class;
        List<Field> fields = buildFields(infoClass);
        String line = buildLine(fields);
        System.out.println(line);
    }

    private static List<Field> buildFields(Class<?> infoClass) {
        List<Field> fields = new ArrayList<>();
        for(Field field: infoClass.getDeclaredFields()) {
            if(!Modifier.isStatic(field.getModifiers())) {
                fields.add(field);
            }
        }
        return fields;
    }

    private static String buildLine(List<Field> fields) {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(field.getName());
        }
        return sb.toString();
    }
}
  