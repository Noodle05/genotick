package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MultiplyVariableByVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -2530246252784080647L;

    private MultiplyVariableByVariable(MultiplyVariableByVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MultiplyVariableByVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MultiplyVariableByVariable copy() {
        return new MultiplyVariableByVariable(this);
    }

}
