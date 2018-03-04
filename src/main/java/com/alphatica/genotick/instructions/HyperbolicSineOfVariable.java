package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicSineOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private HyperbolicSineOfVariable(HyperbolicSineOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicSineOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HyperbolicSineOfVariable copy() {
        return new HyperbolicSineOfVariable(this);
    }
}
