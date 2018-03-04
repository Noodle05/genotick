package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterLessThanRegister extends RegRegJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6368830686936614448L;

    private JumpIfRegisterLessThanRegister(JumpIfRegisterLessThanRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterLessThanRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterLessThanRegister copy() {
        return new JumpIfRegisterLessThanRegister(this);
    }
}
