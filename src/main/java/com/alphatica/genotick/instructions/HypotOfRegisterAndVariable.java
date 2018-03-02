package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HypotOfRegisterAndVariable extends RegVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7846370685515767796L;

    private HypotOfRegisterAndVariable(HypotOfRegisterAndVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HypotOfRegisterAndVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HypotOfRegisterAndVariable copy() {
        return new HypotOfRegisterAndVariable(this);
    }

}
