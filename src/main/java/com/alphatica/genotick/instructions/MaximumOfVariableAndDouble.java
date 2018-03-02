package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MaximumOfVariableAndDouble extends VarDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2277032167143213475L;

    private MaximumOfVariableAndDouble(MaximumOfVariableAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MaximumOfVariableAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MaximumOfVariableAndDouble copy() {
        return new MaximumOfVariableAndDouble(this);
    }

}
