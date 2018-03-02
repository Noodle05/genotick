package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CeilingOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private CeilingOfRegister(CeilingOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CeilingOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public CeilingOfRegister copy() {
        return new CeilingOfRegister(this);
    }
}
