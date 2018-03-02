package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArcsineOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private ArcsineOfRegister(ArcsineOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArcsineOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public ArcsineOfRegister copy() {
        return new ArcsineOfRegister(this);
    }
}
