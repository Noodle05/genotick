package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class TangentOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private TangentOfData(TangentOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public TangentOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public TangentOfData copy() {
        return new TangentOfData(this);
    }
}
