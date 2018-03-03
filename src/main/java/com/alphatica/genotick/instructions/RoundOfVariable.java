package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class RoundOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private RoundOfVariable(RoundOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public RoundOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public RoundOfVariable copy() {
        return new RoundOfVariable(this);
    }
}
