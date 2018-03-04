package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ArctangentOfData extends DataRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private ArctangentOfData(ArctangentOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ArctangentOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public ArctangentOfData copy() {
        return new ArctangentOfData(this);
    }
}
