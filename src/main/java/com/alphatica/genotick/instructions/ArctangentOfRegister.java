package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArctangentOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private ArctangentOfRegister(ArctangentOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArctangentOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public ArctangentOfRegister copy() {
        return new ArctangentOfRegister(this);
    }
}
