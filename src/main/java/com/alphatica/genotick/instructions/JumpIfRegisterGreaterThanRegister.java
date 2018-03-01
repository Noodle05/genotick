package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterGreaterThanRegister extends RegRegJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -7544201771600408606L;

    private JumpIfRegisterGreaterThanRegister(JumpIfRegisterGreaterThanRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterGreaterThanRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterGreaterThanRegister copy() {
        return new JumpIfRegisterGreaterThanRegister(this);
    }
}
