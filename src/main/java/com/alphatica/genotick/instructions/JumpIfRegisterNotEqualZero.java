package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterNotEqualZero extends RegJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -6429106660478254250L;

    private JumpIfRegisterNotEqualZero(JumpIfRegisterNotEqualZero i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterNotEqualZero() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterNotEqualZero copy() {
        return new JumpIfRegisterNotEqualZero(this);
    }
}