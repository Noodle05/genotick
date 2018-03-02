package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ModulusOfVariableAndDouble extends VarDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2277032167143213475L;

    private ModulusOfVariableAndDouble(ModulusOfVariableAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ModulusOfVariableAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ModulusOfVariableAndDouble copy() {
        return new ModulusOfVariableAndDouble(this);
    }

}
