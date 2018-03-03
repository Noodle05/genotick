package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class FloorOfVariable extends VarVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3112125542251877233L;

    private FloorOfVariable(FloorOfVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public FloorOfVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public FloorOfVariable copy() {
        return new FloorOfVariable(this);
    }
}
