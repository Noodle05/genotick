package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicTangentOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private HyperbolicTangentOfRegister(HyperbolicTangentOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicTangentOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public HyperbolicTangentOfRegister copy() {
        return new HyperbolicTangentOfRegister(this);
    }
}
