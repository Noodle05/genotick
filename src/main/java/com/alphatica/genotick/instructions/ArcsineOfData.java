package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArcsineOfData extends DataRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private ArcsineOfData(ArcsineOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArcsineOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public ArcsineOfData copy() {
        return new ArcsineOfData(this);
    }
}
