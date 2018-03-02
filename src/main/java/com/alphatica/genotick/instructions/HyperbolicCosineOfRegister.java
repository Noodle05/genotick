package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicCosineOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private HyperbolicCosineOfRegister(HyperbolicCosineOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicCosineOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public HyperbolicCosineOfRegister copy() {
        return new HyperbolicCosineOfRegister(this);
    }
}
