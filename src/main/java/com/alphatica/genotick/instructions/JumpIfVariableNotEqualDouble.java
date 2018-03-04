package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfVariableNotEqualDouble extends VarDoubleJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 3542351953333254754L;

    private JumpIfVariableNotEqualDouble(JumpIfVariableNotEqualDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfVariableNotEqualDouble() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfVariableNotEqualDouble copy() {
        return new JumpIfVariableNotEqualDouble(this);
    }
}
