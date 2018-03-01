package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class LowestOfColumn extends RegRegInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = -6945803435707758563L;

    private LowestOfColumn(LowestOfColumn i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public LowestOfColumn() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public Instruction copy() {
        return new LowestOfColumn(this);
    }
}
