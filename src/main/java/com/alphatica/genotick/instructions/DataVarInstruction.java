package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class DataVarInstruction extends DataInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7780679428775612562L;

    private int variableArgument;

    protected DataVarInstruction(DataVarInstruction i) {
        this.variableArgument = i.variableArgument;
    }
    
    @SuppressWarnings("unused")
    public DataVarInstruction() {
    }

    void setVariableArgument(int variableArgument) {
        this.variableArgument = variableArgument;
    }

    public int getVariableArgument() {
        return variableArgument;
    }
    @Override
    public void mutate(Mutator mutator) {
        super.mutate(mutator);
        variableArgument = mutator.getNextInt();
    }

    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}
