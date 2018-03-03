package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class AbsoluteOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private AbsoluteOfVariable(AbsoluteOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AbsoluteOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public AbsoluteOfVariable copy() {
        return new AbsoluteOfVariable(this);
    }
}
