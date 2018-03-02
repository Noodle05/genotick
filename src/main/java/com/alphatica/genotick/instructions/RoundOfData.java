package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class RoundOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private RoundOfData(RoundOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public RoundOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public RoundOfData copy() {
        return new RoundOfData(this);
    }
}
