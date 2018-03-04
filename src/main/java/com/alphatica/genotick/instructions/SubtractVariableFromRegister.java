package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SubtractVariableFromRegister extends RegVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -8639456508845181659L;

    private SubtractVariableFromRegister(SubtractVariableFromRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SubtractVariableFromRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public SubtractVariableFromRegister copy() {
        return new SubtractVariableFromRegister(this);
    }

}
