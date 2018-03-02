package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArccosineOfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private ArccosineOfVariable(ArccosineOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArccosineOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ArccosineOfVariable copy() {
        return new ArccosineOfVariable(this);
    }
}
