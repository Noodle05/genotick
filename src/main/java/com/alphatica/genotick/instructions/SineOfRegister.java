package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SineOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private SineOfRegister(SineOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SineOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public SineOfRegister copy() {
        return new SineOfRegister(this);
    }
}
