package com.alphatica.genotick.processor;


import com.alphatica.genotick.instructions.*;

abstract public class Processor {

    abstract public void execute(DivideRegisterByDouble ins);

    abstract public void execute(MultiplyRegisterByDouble ins);

    abstract public void execute(SwapRegisters ins);

    abstract public void execute(MoveDoubleToRegister ins);

    abstract public void execute(ZeroOutRegister ins);

    abstract public void execute(IncrementRegister ins);

    abstract public void execute(DecrementRegister ins);

    abstract public void execute(AddDoubleToRegister ins);

    abstract public void execute(SubtractDoubleFromRegister ins);

    abstract public void execute(DivideVariableByDouble ins);

    abstract public void execute(MultiplyVariableByDouble ins);

    abstract public void execute(SwapVariables ins);

    abstract public void execute(MoveDoubleToVariable ins);

    abstract public void execute(ZeroOutVariable ins);

    abstract public void execute(IncrementVariable ins);

    abstract public void execute(DecrementVariable ins);

    abstract public void execute(AddDoubleToVariable ins);

    abstract public void execute(SubtractDoubleFromVariable ins);

    abstract public void execute(DivideRegisterByRegister ins);

    abstract public void execute(MultiplyRegisterByRegister ins);

    abstract public void execute(AddRegisterToRegister ins);

    abstract public void execute(SubtractRegisterFromRegister ins);

    abstract public void execute(MoveRegisterToRegister ins);

    abstract public void execute(DivideRegisterByVariable ins);

    abstract public void execute(MultiplyRegisterByVariable ins);

    abstract public void execute(AddRegisterToVariable ins);

    abstract public void execute(SubtractRegisterFromVariable ins);

    abstract public void execute(MoveRegisterToVariable ins);

    abstract public void execute(DivideVariableByVariable ins);

    abstract public void execute(MultiplyVariableByVariable ins);

    abstract public void execute(AddVariableToVariable ins);

    abstract public void execute(SubtractVariableFromVariable ins);

    abstract public void execute(MoveVariableToVariable ins);

    abstract public void execute(DivideVariableByRegister ins);

    abstract public void execute(SubtractVariableFromRegister ins);

    abstract public void execute(MoveVariableToRegister ins);

    abstract public void execute(ReturnRegisterAsResult ins);

    abstract public void execute(ReturnVariableAsResult ins);

    @SuppressWarnings("UnusedParameters")
    abstract public void execute(TerminateInstructionList ins);

    abstract public void execute(MoveDataToRegister ins);

    abstract public void execute(MoveDataToVariable ins);

    abstract public void execute(MoveRelativeDataToRegister ins);

    abstract public void execute(MoveRelativeDataToVariable ins);

    abstract public void execute(JumpTo ins);

    abstract public void execute(JumpIfVariableGreaterThanRegister ins);

    abstract public void execute(JumpIfVariableLessThanRegister ins);

    abstract public void execute(JumpIfVariableEqualRegister ins);

    abstract public void execute(JumpIfVariableNotEqualRegister ins);

    abstract public void execute(JumpIfRegisterEqualRegister ins);

    abstract public void execute(JumpIfRegisterNotEqualRegister ins);

    abstract public void execute(JumpIfRegisterGreaterThanRegister ins);

    abstract public void execute(JumpIfRegisterLessThanRegister ins);

    abstract public void execute(JumpIfVariableGreaterThanVariable ins);

    abstract public void execute(JumpIfVariableLessThanVariable ins);

    abstract public void execute(JumpIfVariableEqualVariable ins);

    abstract public void execute(JumpIfVariableNotEqualVariable ins);

    abstract public void execute(JumpIfVariableGreaterThanDouble ins);

    abstract public void execute(JumpIfVariableLessThanDouble ins);

    abstract public void execute(JumpIfVariableEqualDouble ins);

    abstract public void execute(JumpIfVariableNotEqualDouble ins);

    abstract public void execute(JumpIfRegisterGreaterThanDouble ins);

    abstract public void execute(JumpIfRegisterLessThanDouble ins);

    abstract public void execute(JumpIfRegisterEqualDouble ins);

    abstract public void execute(JumpIfRegisterNotEqualDouble ins);

    abstract public void execute(JumpIfRegisterEqualZero ins);

    abstract public void execute(JumpIfRegisterNotEqualZero ins);

    abstract public void execute(JumpIfRegisterGreaterThanZero ins);

    abstract public void execute(JumpIfRegisterLessThanZero ins);

    abstract public void execute(JumpIfVariableEqualZero ins);

    abstract public void execute(JumpIfVariableNotEqualZero ins);

    abstract public void execute(JumpIfVariableGreaterThanZero ins);

    abstract public void execute(JumpIfVariableLessThanZero ins);

    abstract public void execute(NaturalLogarithmOfData ins);

    abstract public void execute(NaturalLogarithmOfRegister ins);

    abstract public void execute(NaturalLogarithmOfVariable ins);

    abstract public void execute(NaturalLogarithm10OfData ins);

    abstract public void execute(NaturalLogarithm10OfRegister ins);

    abstract public void execute(NaturalLogarithm10OfVariable ins);

    abstract public void execute(SqRootOfRegister ins);

    abstract public void execute(SqRootOfVariable ins);

    abstract public void execute(CbRootOfRegister ins);

    abstract public void execute(CbRootOfVariable ins);

    abstract public void execute(SumOfColumn ins);

    abstract public void execute(AverageOfColumn ins);

    abstract public void execute(PercentileOfColumn ins);

    abstract public void execute(FibonacciOfColumn ins);

    abstract public void execute(HighestOfColumn ins);

    abstract public void execute(LowestOfColumn ins);

    abstract public void execute(AbsoluteOfData ins);

    abstract public void execute(AbsoluteOfRegister ins);

    abstract public void execute(AbsoluteOfVariable ins);

    abstract public void execute(NegationOfData ins);

    abstract public void execute(NegationOfRegister ins);

    abstract public void execute(NegationOfVariable ins);

    abstract public void execute(CeilingOfData ins);

    abstract public void execute(CeilingOfRegister ins);

    abstract public void execute(CeilingOfVariable ins);

    abstract public void execute(FloorOfData ins);

    abstract public void execute(FloorOfRegister ins);

    abstract public void execute(FloorOfVariable ins);

    abstract public void execute(RoundOfData ins);

    abstract public void execute(RoundOfRegister ins);

    abstract public void execute(RoundOfVariable ins);

    abstract public void execute(MaximumOfRegisterAndDouble ins);

    abstract public void execute(MaximumOfRegisterAndRegister ins);

    abstract public void execute(MaximumOfRegisterAndVariable ins);

    abstract public void execute(MaximumOfVariableAndDouble ins);

    abstract public void execute(MaximumOfVariableAndVariable ins);

    abstract public void execute(MinimumOfRegisterAndDouble ins);

    abstract public void execute(MinimumOfRegisterAndRegister ins);

    abstract public void execute(MinimumOfRegisterAndVariable ins);

    abstract public void execute(MinimumOfVariableAndDouble ins);

    abstract public void execute(MinimumOfVariableAndVariable ins);

    abstract public void execute(ModulusOfRegisterAndDouble ins);

    abstract public void execute(ModulusOfRegisterAndRegister ins);

    abstract public void execute(ModulusOfRegisterAndVariable ins);

    abstract public void execute(ModulusOfVariableAndDouble ins);

    abstract public void execute(ModulusOfVariableAndVariable ins);

    abstract public void execute(HypotOfRegisterAndDouble ins);

    abstract public void execute(HypotOfRegisterAndRegister ins);

    abstract public void execute(HypotOfRegisterAndVariable ins);

    abstract public void execute(HypotOfVariableAndDouble ins);

    abstract public void execute(HypotOfVariableAndVariable ins);

    abstract public void execute(CosineOfData ins);

    abstract public void execute(CosineOfRegister ins);

    abstract public void execute(CosineOfVariable ins);

    abstract public void execute(ArccosineOfData ins);

    abstract public void execute(ArccosineOfRegister ins);

    abstract public void execute(ArccosineOfVariable ins);

    abstract public void execute(SineOfData ins);

    abstract public void execute(SineOfRegister ins);

    abstract public void execute(SineOfVariable ins);

    abstract public void execute(ArcsineOfData ins);

    abstract public void execute(ArcsineOfRegister ins);

    abstract public void execute(ArcsineOfVariable ins);

    abstract public void execute(TangentOfData ins);

    abstract public void execute(TangentOfRegister ins);

    abstract public void execute(TangentOfVariable ins);

    abstract public void execute(ArctangentOfData ins);

    abstract public void execute(ArctangentOfRegister ins);

    abstract public void execute(ArctangentOfVariable ins);

    abstract public void execute(HyperbolicSineOfData ins);

    abstract public void execute(HyperbolicSineOfRegister ins);

    abstract public void execute(HyperbolicSineOfVariable ins);

    abstract public void execute(HyperbolicCosineOfData ins);

    abstract public void execute(HyperbolicCosineOfRegister ins);

    abstract public void execute(HyperbolicCosineOfVariable ins);

    abstract public void execute(HyperbolicTangentOfData ins);

    abstract public void execute(HyperbolicTangentOfRegister ins);

    abstract public void execute(HyperbolicTangentOfVariable ins);
}
