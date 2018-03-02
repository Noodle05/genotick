package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArctangentOfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private ArctangentOfVariable(ArctangentOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArctangentOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ArctangentOfVariable copy() {
        return new ArctangentOfVariable(this);
    }
}
