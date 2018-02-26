package com.alphatica.genotick.population;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.alphatica.genotick.breeder.BreederSettings;
import com.alphatica.genotick.genotick.WeightCalculator;

public class RobotSettings implements Serializable {

    private static final long serialVersionUID = 6515773193874098850L;
    
    public final int maximumDataOffset;
    public final int minimumRobotVariables;
    public final int maximumRobotVariables;
    public final int ignoreColumns;
    public final int columnCount;
    public final WeightCalculator weightCalculator;
    
    public RobotSettings(final BreederSettings settings, final WeightCalculator weightCalculator) {
        this.maximumDataOffset = settings.maximumDataOffset;
        this.minimumRobotVariables = settings.minimumRobotVariables;
        this.maximumRobotVariables = settings.maximumRobotVariables;
        this.ignoreColumns = settings.ignoreColumns;
        this.columnCount = settings.columnCount;
        this.weightCalculator = weightCalculator;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Field [] fields = getClass().getDeclaredFields();
        for(Field field: fields) {
            field.setAccessible(true);
            if(!Modifier.isStatic(field.getModifiers())) {
                try {
                    Object object = field.get(this);
                    if(sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(object.toString());
                } catch(IllegalAccessException ex) {
                    ;
                }
            }
        }
        return sb.toString();
    }
}
