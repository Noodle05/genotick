package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArccosineOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private ArccosineOfRegister(ArccosineOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArccosineOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public ArccosineOfRegister copy() {
        return new ArccosineOfRegister(this);
    }
}
