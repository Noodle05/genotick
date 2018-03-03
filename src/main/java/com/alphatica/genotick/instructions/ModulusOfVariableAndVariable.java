package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ModulusOfVariableAndVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2684230146996510206L;

    private ModulusOfVariableAndVariable(ModulusOfVariableAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ModulusOfVariableAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ModulusOfVariableAndVariable copy() {
        return new ModulusOfVariableAndVariable(this);
    }

}
