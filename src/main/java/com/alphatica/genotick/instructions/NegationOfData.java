package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NegationOfData extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private NegationOfData(NegationOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NegationOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public NegationOfData copy() {
        return new NegationOfData(this);
    }
}
