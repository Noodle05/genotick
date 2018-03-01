package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class AddVariableToVariable extends VarVarInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 232466498704321646L;

    private AddVariableToVariable(AddVariableToVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public AddVariableToVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public AddVariableToVariable copy() {
        return new AddVariableToVariable(this);
    }

}
