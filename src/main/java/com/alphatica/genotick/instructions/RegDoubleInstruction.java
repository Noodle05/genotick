package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class RegDoubleInstruction extends RegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -8574875071910464339L;

    private double doubleArgument;

    protected RegDoubleInstruction(RegDoubleInstruction i) {
        super(i);
        this.doubleArgument = i.doubleArgument;
    }
    
    @SuppressWarnings("unused")
    protected RegDoubleInstruction() {
        super();
    }
    
    void setDoubleArgument(double doubleArgument) {
        this.doubleArgument = doubleArgument;
    }

    public double getDoubleArgument() {
        return doubleArgument;
    }

    @Override
    public Instruction mutate(Mutator mutator) {
        super.mutate(mutator);
        if(doubleArgument == 0) {
            doubleArgument = Tools.mutateDouble(1_000_000 * mutator.getNextDouble(), mutator);
        }
        doubleArgument = Tools.mutateDouble(doubleArgument, mutator);
        return this;
    }
    
    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}
