package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class VarDoubleInstruction extends VarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5798418310767182684L;

    private double doubleArgument;

    protected VarDoubleInstruction(VarDoubleInstruction i) {
        super(i);
        this.doubleArgument = i.doubleArgument;
    }
    
    @SuppressWarnings("unused")
    public VarDoubleInstruction() {
        super();
    }

    void setDoubleArgument(double doubleArgument) {
        this.doubleArgument = doubleArgument;
    }

    public double getDoubleArgument() {
        return doubleArgument;
    }

    @Override
    public void mutate(Mutator mutator) {
        super.mutate(mutator);
        if(doubleArgument == 0) {
            doubleArgument = Tools.mutateDouble(1_000_000 * mutator.getNextDouble(), mutator);
        }
        doubleArgument = Tools.mutateDouble(doubleArgument, mutator);
    }

    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}

