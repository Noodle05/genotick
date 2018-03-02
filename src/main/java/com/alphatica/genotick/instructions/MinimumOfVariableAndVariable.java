package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MinimumOfVariableAndVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2684230146996510206L;

    private MinimumOfVariableAndVariable(MinimumOfVariableAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MinimumOfVariableAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MinimumOfVariableAndVariable copy() {
        return new MinimumOfVariableAndVariable(this);
    }

}
