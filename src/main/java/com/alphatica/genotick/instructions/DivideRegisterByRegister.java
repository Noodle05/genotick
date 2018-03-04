package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class DivideRegisterByRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5202607381101727036L;

    private DivideRegisterByRegister(DivideRegisterByRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public DivideRegisterByRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public DivideRegisterByRegister copy() {
        return new DivideRegisterByRegister(this);
    }

}
