package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class AverageOfColumn extends RegRegInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = -329518949586814597L;

    private AverageOfColumn(AverageOfColumn i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AverageOfColumn() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public Instruction copy() {
        return new AverageOfColumn(this);
    }
    
    @Override 
    public double getPrevalence(InstructionList il) {
        return getDecayingPrevalence(il, this, this.getClass(), 1.0);
    }
}
