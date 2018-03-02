package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SineOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private SineOfData(SineOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SineOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public SineOfData copy() {
        return new SineOfData(this);
    }
}
