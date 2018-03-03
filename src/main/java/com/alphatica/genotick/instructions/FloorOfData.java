package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class FloorOfData extends DataRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private FloorOfData(FloorOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public FloorOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public FloorOfData copy() {
        return new FloorOfData(this);
    }
}
