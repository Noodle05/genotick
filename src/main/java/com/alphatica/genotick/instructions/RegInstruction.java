package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class RegInstruction extends Instruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5825464773734754580L;

    private byte register;

    protected RegInstruction(RegInstruction i) {
        this.register = i.register;
    }

    @SuppressWarnings("unused")
    protected RegInstruction() {
    }
    
    public byte getRegister() {
        return register;
    }

    void setRegister(byte register) {
        this.register = Registers.validateRegister(register);
    }

    @Override
    public void mutate(Mutator mutator) {
        register = Registers.validateRegister(mutator.getNextByte());

    }

    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}
