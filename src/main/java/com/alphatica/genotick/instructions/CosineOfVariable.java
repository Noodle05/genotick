package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CosineOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private CosineOfVariable(CosineOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CosineOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public CosineOfVariable copy() {
        return new CosineOfVariable(this);
    }
}
