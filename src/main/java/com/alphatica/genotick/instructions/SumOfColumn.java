package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SumOfColumn extends RegRegInstruction {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = -4448791341243829694L;

    private SumOfColumn(SumOfColumn i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SumOfColumn() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public Instruction copy() {
        return new SumOfColumn(this);
    }
}
