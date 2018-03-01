package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MoveDataToRegister extends DataRegInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6441937261061215492L;

    private MoveDataToRegister(MoveDataToRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MoveDataToRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public MoveDataToRegister copy() {
        return new MoveDataToRegister(this);
    }
}
