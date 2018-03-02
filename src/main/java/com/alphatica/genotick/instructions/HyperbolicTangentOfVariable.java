package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HyperbolicTangentOfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private HyperbolicTangentOfVariable(HyperbolicTangentOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HyperbolicTangentOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HyperbolicTangentOfVariable copy() {
        return new HyperbolicTangentOfVariable(this);
    }
}
