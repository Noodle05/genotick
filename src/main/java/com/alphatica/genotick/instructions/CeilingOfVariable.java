package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class CeilingOfVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private CeilingOfVariable(CeilingOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public CeilingOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public CeilingOfVariable copy() {
        return new CeilingOfVariable(this);
    }
}
