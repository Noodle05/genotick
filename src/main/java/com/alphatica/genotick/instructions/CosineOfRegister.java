package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CosineOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private CosineOfRegister(CosineOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CosineOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public CosineOfRegister copy() {
        return new CosineOfRegister(this);
    }
}
