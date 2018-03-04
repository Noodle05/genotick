package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class AddRegisterToRegister extends RegRegInstruction implements MathInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = 3465536183323672440L;

    private AddRegisterToRegister(AddRegisterToRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AddRegisterToRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public AddRegisterToRegister copy() {
        return new AddRegisterToRegister(this);
    }

}
