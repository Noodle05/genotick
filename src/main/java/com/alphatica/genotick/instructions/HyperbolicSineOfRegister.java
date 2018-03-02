package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicSineOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private HyperbolicSineOfRegister(HyperbolicSineOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicSineOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public HyperbolicSineOfRegister copy() {
        return new HyperbolicSineOfRegister(this);
    }
}
