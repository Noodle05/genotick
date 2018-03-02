package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArccosineOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private ArccosineOfData(ArccosineOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArccosineOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public ArccosineOfData copy() {
        return new ArccosineOfData(this);
    }
}
