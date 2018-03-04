package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MinimumOfRegisterAndDouble extends RegDoubleInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6495799568812947637L;

    private MinimumOfRegisterAndDouble(MinimumOfRegisterAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MinimumOfRegisterAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MinimumOfRegisterAndDouble copy() {
        return new MinimumOfRegisterAndDouble(this);
    }
}
