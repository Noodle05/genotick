package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MaximumOfVariableAndVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2684230146996510206L;

    private MaximumOfVariableAndVariable(MaximumOfVariableAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MaximumOfVariableAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MaximumOfVariableAndVariable copy() {
        return new MaximumOfVariableAndVariable(this);
    }

}
