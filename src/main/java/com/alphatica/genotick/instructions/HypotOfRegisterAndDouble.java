package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HypotOfRegisterAndDouble extends RegDoubleInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6495799568812947637L;

    private HypotOfRegisterAndDouble(HypotOfRegisterAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HypotOfRegisterAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HypotOfRegisterAndDouble copy() {
        return new HypotOfRegisterAndDouble(this);
    }
}
