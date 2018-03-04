package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class VarInstruction extends Instruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5052271226112971349L;

    private int variableArgument;

    protected VarInstruction(VarInstruction i) {
        this.variableArgument = i.variableArgument;
    }
    
    @SuppressWarnings("unused")
    public VarInstruction() {
    }

    public int getVariableArgument() {
        return variableArgument;
    }

    void setVariableArgument(int variableArgument) {
        this.variableArgument = variableArgument;
    }

    @Override
    public Instruction mutate(Mutator mutator) {
        variableArgument = mutator.getNextInt();
        return this;
    }

    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}
