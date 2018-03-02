package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicCosineOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private HyperbolicCosineOfData(HyperbolicCosineOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicCosineOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public HyperbolicCosineOfData copy() {
        return new HyperbolicCosineOfData(this);
    }
}
