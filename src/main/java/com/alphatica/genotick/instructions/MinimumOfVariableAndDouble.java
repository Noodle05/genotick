package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MinimumOfVariableAndDouble extends VarDoubleInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2277032167143213475L;

    private MinimumOfVariableAndDouble(MinimumOfVariableAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MinimumOfVariableAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MinimumOfVariableAndDouble copy() {
        return new MinimumOfVariableAndDouble(this);
    }

}
