package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArcsineOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private ArcsineOfVariable(ArcsineOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArcsineOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ArcsineOfVariable copy() {
        return new ArcsineOfVariable(this);
    }
}
