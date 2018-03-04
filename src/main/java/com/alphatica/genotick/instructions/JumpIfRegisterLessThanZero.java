package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterLessThanZero extends RegJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 5576287341828522397L;

    private JumpIfRegisterLessThanZero(JumpIfRegisterLessThanZero i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterLessThanZero() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterLessThanZero copy() {
        return new JumpIfRegisterLessThanZero(this);
    }
}
