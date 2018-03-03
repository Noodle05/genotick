package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class AbsoluteOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private AbsoluteOfRegister(AbsoluteOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AbsoluteOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public AbsoluteOfRegister copy() {
        return new AbsoluteOfRegister(this);
    }
}
