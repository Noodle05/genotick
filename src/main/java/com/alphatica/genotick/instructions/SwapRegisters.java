package com.alphatica.genotick.instructions;


import com.alphatica.genotick.processor.Processor;

public class SwapRegisters extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3433775138789900573L;

    private SwapRegisters(SwapRegisters i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SwapRegisters() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public SwapRegisters copy() {
        return new SwapRegisters(this);
    }
}
