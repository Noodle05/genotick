package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MultiplyRegisterByDouble extends RegDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 7017210446264669933L;

    private MultiplyRegisterByDouble(MultiplyRegisterByDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MultiplyRegisterByDouble() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public MultiplyRegisterByDouble copy() {
        return new MultiplyRegisterByDouble(this);
    }

}
