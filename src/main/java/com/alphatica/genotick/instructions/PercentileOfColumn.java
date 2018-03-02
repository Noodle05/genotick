package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;
import com.alphatica.genotick.processor.Processor;

public class PercentileOfColumn extends RegRegInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = -329518949586814597L;

    // This value is replaced before use by mutate()
    protected int percentile = 95;

    private PercentileOfColumn(PercentileOfColumn i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public PercentileOfColumn() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public Instruction copy() {
        return new PercentileOfColumn(this);
    }
    
    @Override
    public Instruction mutate(Mutator mutator) {
        super.mutate(mutator);
        percentile = (Math.abs(mutator.getNextInt()) % 100) + 1;
        return this;
    }

    public int getPercentile() {
        return percentile;
    }

    @Override 
    public double getPrevalence(InstructionList il) {
        return getDecayingPrevalence(il, this, this.getClass(), 1.0);
    }
}