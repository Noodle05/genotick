package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MaximumOfRegisterAndVariable extends RegVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7846370685515767796L;

    private MaximumOfRegisterAndVariable(MaximumOfRegisterAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MaximumOfRegisterAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MaximumOfRegisterAndVariable copy() {
        return new MaximumOfRegisterAndVariable(this);
    }

}
