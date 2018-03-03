package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MultiplyRegisterByVariable extends RegVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5195803067958383416L;

    private MultiplyRegisterByVariable(MultiplyRegisterByVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MultiplyRegisterByVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MultiplyRegisterByVariable copy() {
        return new MultiplyRegisterByVariable(this);
    }

}
