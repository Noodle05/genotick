package com.alphatica.genotick.instructions;


import com.alphatica.genotick.processor.Processor;

public class AddDoubleToRegister extends RegDoubleInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = 2825034534810488187L;

    private AddDoubleToRegister(AddDoubleToRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AddDoubleToRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public AddDoubleToRegister copy() {
        return new AddDoubleToRegister(this);
    }

}
