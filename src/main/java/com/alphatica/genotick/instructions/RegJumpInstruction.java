package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class RegJumpInstruction extends RegInstruction implements JumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -4386895204308098944L;

    private int address;

    protected RegJumpInstruction(RegJumpInstruction i) {
        super(i);
        this.address = i.address;
    }

    protected RegJumpInstruction() {
        super();
        address = 0;
    }

    @Override
    public int getAddress() {
        return address;
    }
    @Override
    public Instruction mutate(Mutator mutator) {
        super.mutate(mutator);
        address = mutator.getNextInt();
        return this;
    }

    void setAddress(int address) {
        this.address = address;
    }
}
