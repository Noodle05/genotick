package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class FloorOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private FloorOfRegister(FloorOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public FloorOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public FloorOfRegister copy() {
        return new FloorOfRegister(this);
    }
}
