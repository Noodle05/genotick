package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MinimumOfRegisterAndRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5202607381101727036L;

    private MinimumOfRegisterAndRegister(MinimumOfRegisterAndRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MinimumOfRegisterAndRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MinimumOfRegisterAndRegister copy() {
        return new MinimumOfRegisterAndRegister(this);
    }

}
