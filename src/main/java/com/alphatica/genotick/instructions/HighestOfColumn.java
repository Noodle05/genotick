package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HighestOfColumn extends RegRegInstruction implements MathInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7922049215420858405L;

    private HighestOfColumn(HighestOfColumn i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HighestOfColumn() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public Instruction copy() {
        return new HighestOfColumn(this);
    }
}
