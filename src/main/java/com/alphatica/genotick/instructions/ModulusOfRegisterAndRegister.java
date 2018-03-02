package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class ModulusOfRegisterAndRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5202607381101727036L;

    private ModulusOfRegisterAndRegister(ModulusOfRegisterAndRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public ModulusOfRegisterAndRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public ModulusOfRegisterAndRegister copy() {
        return new ModulusOfRegisterAndRegister(this);
    }

}
