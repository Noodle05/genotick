package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfVariableGreaterThanVariable extends VarVarJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6092048224711211254L;

    private JumpIfVariableGreaterThanVariable(JumpIfVariableGreaterThanVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfVariableGreaterThanVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public JumpIfVariableGreaterThanVariable copy() {
        return new JumpIfVariableGreaterThanVariable(this);
    }
}
