package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NaturalLogarithmOfData extends DataRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private NaturalLogarithmOfData(NaturalLogarithmOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NaturalLogarithmOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public NaturalLogarithmOfData copy() {
        return new NaturalLogarithmOfData(this);
    }
}
