
package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class MoveDoubleToVariable extends VarDoubleInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -1120463586513743256L;

    private MoveDoubleToVariable(MoveDoubleToVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public MoveDoubleToVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public MoveDoubleToVariable copy() {
        return new MoveDoubleToVariable(this);
    }

}
