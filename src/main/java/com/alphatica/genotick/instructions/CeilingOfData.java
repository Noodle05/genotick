package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CeilingOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private CeilingOfData(CeilingOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CeilingOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public CeilingOfData copy() {
        return new CeilingOfData(this);
    }
}
