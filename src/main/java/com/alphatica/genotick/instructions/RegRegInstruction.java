package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

public abstract class RegRegInstruction extends Instruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 6740011263492418256L;

    private byte register1;
    private byte register2;
    
    protected RegRegInstruction(RegRegInstruction i) {
        this.register1 = i.register1;
        this.register2 = i.register2;
    }

    @SuppressWarnings("unused")
    public RegRegInstruction() {
    }

    public byte getRegister1() {
        return register1;
    }

    void setRegister1(byte register1) {
        this.register1 = Registers.validateRegister(register1);
    }

    public byte getRegister2() {
        return register2;
    }

    void setRegister2(byte register2) {
        this.register2 = Registers.validateRegister(register2);
    }

    @Override
    public Instruction mutate(Mutator mutator) {
        byte value = Registers.validateRegister(mutator.getNextByte());
        register1 = value;
        value = Registers.validateRegister(mutator.getNextByte());
        register2 = value;
        return this;
    }

    @Override
    public double getPrevalence(InstructionList il) {
        if(il.getInstructionCount() > 0) {
            Instruction in = il.getInstruction(il.getInstructionCount()-1);
            if(in instanceof RegRegInstruction) {
                RegRegInstruction rin = (RegRegInstruction)in;
                if(rin.register1 == this.register1) {
                    // If a previous instruction is also a register instruction,
                    // lower its probability if it is likely to write to the same
                    // instruction as this instruction.  Otherwise the previous
                    // instructions result is overwritten and ignored.
                    return .3;
                }
            }
        }
        // Default prevalence
        return super.getPrevalence(il);
    }
}
