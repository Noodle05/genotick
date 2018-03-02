package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CosineOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private CosineOfData(CosineOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CosineOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public CosineOfData copy() {
        return new CosineOfData(this);
    }
}
