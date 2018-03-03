package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NaturalLogarithm10OfData extends DataRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private NaturalLogarithm10OfData(NaturalLogarithm10OfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NaturalLogarithm10OfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public NaturalLogarithm10OfData copy() {
        return new NaturalLogarithm10OfData(this);
    }
}
