package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SineOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private SineOfVariable(SineOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SineOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public SineOfVariable copy() {
        return new SineOfVariable(this);
    }
}
