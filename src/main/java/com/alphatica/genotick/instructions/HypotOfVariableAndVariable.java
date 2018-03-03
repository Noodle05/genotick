package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HypotOfVariableAndVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2684230146996510206L;

    private HypotOfVariableAndVariable(HypotOfVariableAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HypotOfVariableAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HypotOfVariableAndVariable copy() {
        return new HypotOfVariableAndVariable(this);
    }

}
