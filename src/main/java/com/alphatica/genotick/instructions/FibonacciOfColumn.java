package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;
import com.alphatica.genotick.processor.Processor;

public class FibonacciOfColumn extends RegRegInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = -329518949586814597L;

    private FibonacciOfColumn(FibonacciOfColumn i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public FibonacciOfColumn() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public Instruction copy() {
        return new FibonacciOfColumn(this);
    }
    

    @Override 
    public double getPrevalence(InstructionList il) {
        return getDecayingPrevalence(il, this, this.getClass(), 0.8);
    }
}