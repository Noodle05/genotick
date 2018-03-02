package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class AbsoluteOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private AbsoluteOfData(AbsoluteOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AbsoluteOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public AbsoluteOfData copy() {
        return new AbsoluteOfData(this);
    }
}
