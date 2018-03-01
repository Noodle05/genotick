package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class RegVarInstruction extends RegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2162434928345582409L;

    private int variableArgument;

    protected RegVarInstruction(RegVarInstruction i) {
        super(i);
        this.variableArgument = i.variableArgument;
    }
    
    @SuppressWarnings("unused")
    public RegVarInstruction() {
        super();
    }

    void setVariableArgument(int variable) {
        this.variableArgument = variable;
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
