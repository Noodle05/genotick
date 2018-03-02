package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicCosineOfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private HyperbolicCosineOfVariable(HyperbolicCosineOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicCosineOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HyperbolicCosineOfVariable copy() {
        return new HyperbolicCosineOfVariable(this);
    }
}
