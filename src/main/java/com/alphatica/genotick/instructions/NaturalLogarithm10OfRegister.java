package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NaturalLogarithm10OfRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private NaturalLogarithm10OfRegister(NaturalLogarithm10OfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NaturalLogarithm10OfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public NaturalLogarithm10OfRegister copy() {
        return new NaturalLogarithm10OfRegister(this);
    }
}
