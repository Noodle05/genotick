package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MaximumOfRegisterAndDouble extends RegDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6495799568812947637L;

    private MaximumOfRegisterAndDouble(MaximumOfRegisterAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MaximumOfRegisterAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MaximumOfRegisterAndDouble copy() {
        return new MaximumOfRegisterAndDouble(this);
    }
}
