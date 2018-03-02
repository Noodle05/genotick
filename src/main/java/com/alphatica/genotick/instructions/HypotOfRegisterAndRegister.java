package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class HypotOfRegisterAndRegister extends RegRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5202607381101727036L;

    private HypotOfRegisterAndRegister(HypotOfRegisterAndRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public HypotOfRegisterAndRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public HypotOfRegisterAndRegister copy() {
        return new HypotOfRegisterAndRegister(this);
    }

}
