package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SubtractDoubleFromVariable extends VarDoubleInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 8293191797685003121L;

    private SubtractDoubleFromVariable(SubtractDoubleFromVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SubtractDoubleFromVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public SubtractDoubleFromVariable copy() {
        return new SubtractDoubleFromVariable(this);
    }

}
