package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NaturalLogarithm10OfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private NaturalLogarithm10OfVariable(NaturalLogarithm10OfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NaturalLogarithm10OfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public NaturalLogarithm10OfVariable copy() {
        return new NaturalLogarithm10OfVariable(this);
    }
}
