package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CbRootOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -6025395017177611705L;

    private CbRootOfVariable(CbRootOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CbRootOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public CbRootOfVariable copy() {
        return new CbRootOfVariable(this);
    }
}
