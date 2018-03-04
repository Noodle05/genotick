package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class TangentOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private TangentOfVariable(TangentOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public TangentOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public TangentOfVariable copy() {
        return new TangentOfVariable(this);
    }
}
