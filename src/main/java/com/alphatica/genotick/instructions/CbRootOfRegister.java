package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CbRootOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -2097327161652030023L;

    private CbRootOfRegister(CbRootOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CbRootOfRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public CbRootOfRegister copy() {
        return new CbRootOfRegister(this);
    }
}
