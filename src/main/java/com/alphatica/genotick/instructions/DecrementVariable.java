package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.NotEnoughDataException;
import com.alphatica.genotick.processor.Processor;

public class DecrementVariable extends VarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -3260981819622564798L;

    private DecrementVariable(DecrementVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public DecrementVariable() {
    }

    @Override
    public void executeOn(Processor processor) throws NotEnoughDataException {
        processor.execute(this);
    }

    @Override
    public DecrementVariable copy() {
        return new DecrementVariable(this);
    }

}
