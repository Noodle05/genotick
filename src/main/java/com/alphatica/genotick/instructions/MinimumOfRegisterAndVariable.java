package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MinimumOfRegisterAndVariable extends RegVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7846370685515767796L;

    private MinimumOfRegisterAndVariable(MinimumOfRegisterAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MinimumOfRegisterAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MinimumOfRegisterAndVariable copy() {
        return new MinimumOfRegisterAndVariable(this);
    }

}
