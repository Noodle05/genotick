package com.alphatica.genotick.instructions;


import com.alphatica.genotick.processor.Processor;

public class SwapVariables extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -6328103475159894381L;

    private SwapVariables(SwapVariables i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SwapVariables() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public SwapVariables copy() {
        return new SwapVariables(this);
    }

}
