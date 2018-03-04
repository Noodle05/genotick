package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterEqualRegister extends RegRegJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 3488371896551189695L;

    private JumpIfRegisterEqualRegister(JumpIfRegisterEqualRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterEqualRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterEqualRegister copy() {
        return new JumpIfRegisterEqualRegister(this);
    }
}
