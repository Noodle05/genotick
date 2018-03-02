package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class VarVarInstruction extends Instruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -8461921520321026497L;

    private int variable1Argument;
    private int variable2Argument;

    protected VarVarInstruction(VarVarInstruction i) {
        this.variable1Argument = i.variable1Argument;
        this.variable2Argument = i .variable2Argument;
    }
    
    @SuppressWarnings("unused")
    public VarVarInstruction() {
    }

    public int getVariable1Argument() {
        return variable1Argument;
    }

    void setVariable1Argument(int variable1Argument) {
        this.variable1Argument = variable1Argument;
    }

    public int getVariable2Argument() {
        return variable2Argument;
    }

    void setVariable2Argument(int variable2Argument) {
        this.variable2Argument = variable2Argument;
    }

    @Override
    public Instruction mutate(Mutator mutator) {
        variable1Argument = mutator.getNextInt();
        variable2Argument = mutator.getNextInt();
        return this;
    }

    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}
