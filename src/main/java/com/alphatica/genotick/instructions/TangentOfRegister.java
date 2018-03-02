package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class TangentOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private TangentOfRegister(TangentOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public TangentOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public TangentOfRegister copy() {
        return new TangentOfRegister(this);
    }
}
