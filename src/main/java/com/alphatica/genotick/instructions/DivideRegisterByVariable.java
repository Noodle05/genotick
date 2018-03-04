package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class DivideRegisterByVariable extends RegVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7846370685515767796L;

    private DivideRegisterByVariable(DivideRegisterByVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public DivideRegisterByVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public DivideRegisterByVariable copy() {
        return new DivideRegisterByVariable(this);
    }

}
