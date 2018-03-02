package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HypotOfVariableAndDouble extends VarDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2277032167143213475L;

    private HypotOfVariableAndDouble(HypotOfVariableAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HypotOfVariableAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HypotOfVariableAndDouble copy() {
        return new HypotOfVariableAndDouble(this);
    }

}
