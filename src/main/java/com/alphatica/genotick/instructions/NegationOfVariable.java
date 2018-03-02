package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NegationOfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private NegationOfVariable(NegationOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NegationOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public NegationOfVariable copy() {
        return new NegationOfVariable(this);
    }
}
