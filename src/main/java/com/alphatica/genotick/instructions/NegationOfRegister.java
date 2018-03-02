package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NegationOfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private NegationOfRegister(NegationOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NegationOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public NegationOfRegister copy() {
        return new NegationOfRegister(this);
    }
}
