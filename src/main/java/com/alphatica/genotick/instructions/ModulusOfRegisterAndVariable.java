package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ModulusOfRegisterAndVariable extends RegVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7846370685515767796L;

    private ModulusOfRegisterAndVariable(ModulusOfRegisterAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ModulusOfRegisterAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ModulusOfRegisterAndVariable copy() {
        return new ModulusOfRegisterAndVariable(this);
    }

}
