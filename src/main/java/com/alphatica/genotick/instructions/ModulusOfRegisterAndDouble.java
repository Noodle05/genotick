package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ModulusOfRegisterAndDouble extends RegDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6495799568812947637L;

    private ModulusOfRegisterAndDouble(ModulusOfRegisterAndDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ModulusOfRegisterAndDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ModulusOfRegisterAndDouble copy() {
        return new ModulusOfRegisterAndDouble(this);
    }
}
