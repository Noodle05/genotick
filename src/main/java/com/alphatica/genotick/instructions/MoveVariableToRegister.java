package com.alphatica.genotick.instructions;


import com.alphatica.genotick.processor.Processor;

public class MoveVariableToRegister extends RegVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3943721532302613198L;

    private MoveVariableToRegister(MoveVariableToRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MoveVariableToRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MoveVariableToRegister copy() {
        return new MoveVariableToRegister(this);
    }

}
