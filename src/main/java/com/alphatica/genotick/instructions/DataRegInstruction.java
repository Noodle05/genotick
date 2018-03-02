package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract public class DataRegInstruction extends DataInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 4226724935141470072L;

    private byte register;

    protected DataRegInstruction(DataRegInstruction i) {
        super(i);
        this.register = i.register;
    }
    
    @SuppressWarnings("unused")
    public DataRegInstruction() {
        super();
    }

    public byte getRegister() {
        return register;
    }

    void setRegister(byte register) {
        this.register = Registers.validateRegister(register);
    }

    @Override
    public Instruction mutate(Mutator mutator) {
        super.mutate(mutator);
        register = Registers.validateRegister(mutator.getNextByte());
        return this;
    }

    @Override
    public double getPrevalence(InstructionList il) {
        return 1.0;
    }
}
