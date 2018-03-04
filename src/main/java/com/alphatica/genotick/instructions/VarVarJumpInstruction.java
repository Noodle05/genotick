package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

abstract class VarVarJumpInstruction extends VarVarInstruction implements JumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6418593915852218659L;

    private int address;

    protected VarVarJumpInstruction(VarVarJumpInstruction i) {
        super(i);
        this.address = i.address;
    }

    protected VarVarJumpInstruction() {
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
