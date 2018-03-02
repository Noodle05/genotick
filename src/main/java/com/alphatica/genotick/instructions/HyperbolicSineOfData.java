package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicSineOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private HyperbolicSineOfData(HyperbolicSineOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicSineOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public HyperbolicSineOfData copy() {
        return new HyperbolicSineOfData(this);
    }
}
