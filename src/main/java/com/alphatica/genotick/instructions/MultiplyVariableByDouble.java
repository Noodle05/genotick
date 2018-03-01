package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MultiplyVariableByDouble extends VarDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -488671617233131162L;

    private MultiplyVariableByDouble(MultiplyVariableByDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MultiplyVariableByDouble() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public MultiplyVariableByDouble copy() {
        return new MultiplyVariableByDouble(this);
    }

}
