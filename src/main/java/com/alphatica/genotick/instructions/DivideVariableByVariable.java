package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class DivideVariableByVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2684230146996510206L;

    private DivideVariableByVariable(DivideVariableByVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public DivideVariableByVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public DivideVariableByVariable copy() {
        return new DivideVariableByVariable(this);
    }

}
