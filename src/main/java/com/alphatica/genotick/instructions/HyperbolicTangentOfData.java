package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicTangentOfData extends DataRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3598160310785452494L;

    private HyperbolicTangentOfData(HyperbolicTangentOfData i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicTangentOfData() {
    }

    @Override
    public void executeOn(Processor processor)   {
        processor.execute(this);
    }

    @Override
    public HyperbolicTangentOfData copy() {
        return new HyperbolicTangentOfData(this);
    }
}
