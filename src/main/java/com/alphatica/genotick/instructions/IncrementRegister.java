package com.alphatica.genotick.instructions;


import com.alphatica.genotick.processor.Processor;

public class IncrementRegister extends RegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 3654031193344071193L;

    private IncrementRegister(IncrementRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public IncrementRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public IncrementRegister copy() {
        return new IncrementRegister(this);
    }

}
