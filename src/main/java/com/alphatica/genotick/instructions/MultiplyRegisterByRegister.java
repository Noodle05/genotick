package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MultiplyRegisterByRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 7185538925515388482L;

    private MultiplyRegisterByRegister(MultiplyRegisterByRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MultiplyRegisterByRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MultiplyRegisterByRegister copy() {
        return new MultiplyRegisterByRegister(this);
    }

}
