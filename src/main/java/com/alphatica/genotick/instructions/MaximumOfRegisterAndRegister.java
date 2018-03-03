package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MaximumOfRegisterAndRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5202607381101727036L;

    private MaximumOfRegisterAndRegister(MaximumOfRegisterAndRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MaximumOfRegisterAndRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MaximumOfRegisterAndRegister copy() {
        return new MaximumOfRegisterAndRegister(this);
    }

}
