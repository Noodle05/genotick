package com.alphatica.genotick.mutator;

import com.alphatica.genotick.data.ColumnAccess;
import com.alphatica.genotick.instructions.Instruction;
import com.alphatica.genotick.instructions.InstructionList;

public interface Mutator {
    Instruction getRandomInstruction(InstructionList il);

    boolean getAllowInstructionMutation();

    boolean getAllowNewInstruction();

    int getNextInt();
    
    int getNextColumn();

    double getNextDouble();

    byte getNextByte();

    void setSettings(MutatorSettings mutatorSettings);
    
    void setColumnAccess(ColumnAccess columnAccess);

    boolean skipNextInstruction();

}
