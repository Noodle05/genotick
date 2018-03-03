package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class RoundOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private RoundOfRegister(RoundOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public RoundOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public RoundOfRegister copy() {
        return new RoundOfRegister(this);
    }
}
