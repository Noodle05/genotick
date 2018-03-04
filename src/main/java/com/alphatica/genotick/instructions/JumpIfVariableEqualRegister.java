package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfVariableEqualRegister extends RegVarJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -8121933377560453966L;

    private JumpIfVariableEqualRegister(JumpIfVariableEqualRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfVariableEqualRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public JumpIfVariableEqualRegister copy() {
        return new JumpIfVariableEqualRegister(this);
    }
}
