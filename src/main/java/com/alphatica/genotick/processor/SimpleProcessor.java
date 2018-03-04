package com.alphatica.genotick.processor;

import com.alphatica.genotick.data.ColumnAccess;
import com.alphatica.genotick.genotick.Prediction;
import com.alphatica.genotick.genotick.RobotData;
import com.alphatica.genotick.instructions.*;

import com.alphatica.genotick.population.Robot;
import com.alphatica.genotick.population.RobotExecutor;
import com.alphatica.genotick.population.RobotExecutorSettings;

import java.util.Arrays;

public class SimpleProcessor extends Processor implements RobotExecutor {

    private static final int MAX_JUMP = 255;
    private final double[] registers = new double[totalRegisters];
    private final int processorInstructionLimit;

    private RobotData data;
    private int dataColumns;
    private double robotResult;
    private boolean finished;
    private InstructionList instructionList;
    private int instructionLimit;
    private boolean terminateInstructionList;
    private int changeInstructionPointer;
    private int totalInstructionExecuted;
    private int maximumDataOffset;
    private int ignoreColumns;
    private ColumnAccess columnAccess;

    private SimpleProcessor(RobotExecutorSettings settings) {
        processorInstructionLimit = settings.maximumProcessorInstructionFactor;
    }
    
    public static SimpleProcessor getInstance(RobotExecutorSettings settings) {
        return new SimpleProcessor(settings);
    }

    @Override
    public Prediction executeRobot(RobotData robotData, Robot robot) {
        prepare(robotData, robot);
        try {
            return executeRobotMain();
        } catch (NotEnoughDataException |
                TooManyInstructionsExecuted |
                ArithmeticException ex) {
            return Prediction.OUT;
        }
    }

    private void prepare(RobotData robotData, Robot robot) {
        this.data = robotData;
        dataColumns = data.getTrainingColumnCount();
        robotResult = 0.0;
        finished = false;
        instructionList = robot.getMainFunction();
        instructionList.zeroOutVariables();
        instructionLimit = robot.getLength() * processorInstructionLimit;
        terminateInstructionList = false;
        changeInstructionPointer = 0;
        totalInstructionExecuted = 0;
        maximumDataOffset = robot.getMaximumDataOffset();
        ignoreColumns = robot.getIgnoreColumns();
        columnAccess = robot.getColumnAccess();
        zeroOutRegisters();
    }

    private void zeroOutRegisters() {
        Arrays.fill(registers, 0.0);
    }

    private Prediction executeRobotMain()  {
        executeInstructionList();
        if (finished) {
            return Prediction.getPrediction(robotResult);
        } else {
            return Prediction.getPrediction(registers[0]);
        }
    }

    private void executeInstructionList()  {
        int instructionPointer = 0;
        do {
            Instruction instruction = instructionList.getInstruction(instructionPointer++);
            instruction.executeOn(this);
            totalInstructionExecuted++;
            if(totalInstructionExecuted > instructionLimit) {
                break;
            }
            //instructionPointer = Math.abs((instructionPointer + changeInstructionPointer) % instructionList.getSize());
            //changeInstructionPointer = 0;
        } while (!terminateInstructionList && !finished);
    }

    @Override
    public void execute(SwapRegisters ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        double tmp = registers[reg1];
        registers[reg1] = registers[reg2];
        registers[reg2] = tmp;
    }

    @Override
    public void execute(IncrementRegister ins) {
        int reg = ins.getRegister();
        registers[reg]++;
    }

    @Override
    public void execute(MoveDoubleToRegister ins) {
        int reg = ins.getRegister();
        registers[reg] = ins.getDoubleArgument();
    }

    @Override
    public void execute(AddDoubleToRegister ins) {
        int reg = ins.getRegister();
        registers[reg] += ins.getDoubleArgument();
    }

    @Override
    public void execute(ZeroOutRegister ins) {
        int reg = ins.getRegister();
        registers[reg] = 0;
    }

    @Override
    public void execute(ReturnRegisterAsResult ins) {
        int reg = ins.getRegister();
        robotResult = registers[reg];
        finished = true;
    }

    @Override
    public void execute(@SuppressWarnings("unused") TerminateInstructionList ins) {
        terminateInstructionList = true;
    }

    @Override
    public void execute(DecrementRegister ins) {
        int reg = ins.getRegister();
        registers[reg]--;
    }

    @Override
    public void execute(MoveRegisterToRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] = registers[reg2];
    }

    @Override
    public void execute(MoveVariableToRegister ins) {
        int reg = ins.getRegister();
        registers[reg] = instructionList.getVariable(ins.getVariableArgument());
    }

    @Override
    public void execute(MoveRegisterToVariable ins) {
        int reg = ins.getRegister();
        instructionList.setVariable(ins.getVariableArgument(), registers[reg]);
    }

    @Override
    public void execute(MultiplyRegisterByRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] *= registers[reg2];
    }

    @Override
    public void execute(MultiplyRegisterByVariable ins) {
        int reg = ins.getRegister();
        registers[reg] *= instructionList.getVariable(ins.getVariableArgument());
    }

    @Override
    public void execute(MultiplyVariableByVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), var1 * var2);
    }

    @Override
    public void execute(SubtractDoubleFromRegister ins) {
        int reg = ins.getRegister();
        registers[reg] -= ins.getDoubleArgument();
    }

    @Override
    public void execute(MoveDoubleToVariable ins) {
        instructionList.setVariable(ins.getVariableArgument(), ins.getDoubleArgument());
    }

    @Override
    public void execute(DivideRegisterByRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] /= registers[reg2];
    }

    @Override
    public void execute(DivideRegisterByVariable ins) {
        int reg = ins.getRegister();
        double var = instructionList.getVariable(ins.getVariableArgument());
        registers[reg] /= var;
    }

    @Override
    public void execute(DivideVariableByVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), var1 / var2);
    }

    @Override
    public void execute(DivideVariableByRegister ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        int reg = ins.getRegister();
        instructionList.setVariable(ins.getVariableArgument(), var / registers[reg]);
    }

    @Override
    public void execute(ReturnVariableAsResult ins) {
        robotResult = instructionList.getVariable(ins.getVariableArgument());
        finished = true;
    }

    @Override
    public void execute(AddRegisterToRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] += registers[reg2];
    }

    @Override
    public void execute(SubtractRegisterFromRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] -= registers[reg2];
    }

    @Override
    public void execute(MoveDataToRegister ins) {
        int reg = ins.getRegister();
        int offset = fixOffset(ins.getDataOffsetIndex());
        int column = fixColumn(ins.getDataColumnIndex());
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        registers[reg] = data.getTrainingPriceData(column, offset);
    }


    @Override
    public void execute(MoveDataToVariable ins) {
        int offset = fixOffset(ins.getDataOffsetIndex());
        int column = fixColumn(ins.getDataColumnIndex());
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        double value = data.getTrainingPriceData(column, offset);
        instructionList.setVariable(ins.getVariableArgument(),value);
    }

    @Override
    public void execute(MoveRelativeDataToRegister ins)  {
        int reg = ins.getRegister();
        int varOffset = getRelativeOffset(ins);
        int column = fixColumn(ins.getDataColumnIndex());
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        registers[reg] = data.getTrainingPriceData(column, varOffset);
    }

    @Override
    public void execute(MoveRelativeDataToVariable ins) {
        int varOffset = getRelativeOffset(ins);
        int column = fixColumn(ins.getDataColumnIndex());
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        double value = data.getTrainingPriceData(column, varOffset);
        instructionList.setVariable(ins.getVariableArgument(), value);
    }

    @Override
    public void execute(JumpTo ins) {
        jumpTo(ins.getAddress());
    }
    private void jumpTo(int jumpAddress) {
        changeInstructionPointer = (jumpAddress % MAX_JUMP);
    }

    @Override
    public void execute(JumpIfVariableGreaterThanRegister ins) {
        double register = registers[ins.getRegister()];
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(variable > register) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableLessThanRegister ins) {
        double register = registers[ins.getRegister()];
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(variable < register) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableEqualRegister ins) {
        double register = registers[ins.getRegister()];
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(0 == Double.compare(variable, register)) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableNotEqualRegister ins) {
        double register = registers[ins.getRegister()];
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(0 != Double.compare(variable, register)) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterEqualRegister ins) {
        double register1 = registers[ins.getRegister1()];
        double register2 = registers[ins.getRegister2()];
        if(0 == Double.compare(register1, register2)) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterNotEqualRegister ins) {
        double register1 = registers[ins.getRegister1()];
        double register2 = registers[ins.getRegister2()];
        if(0 != Double.compare(register1, register2)) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterGreaterThanRegister ins) {
        double register1 = registers[ins.getRegister1()];
        double register2 = registers[ins.getRegister2()];
        if(Double.compare(register1, register2) > 0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterLessThanRegister ins) {
        double register1 = registers[ins.getRegister1()];
        double register2 = registers[ins.getRegister2()];
        if(Double.compare(register1, register2) < 0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableGreaterThanVariable ins) {
        double variable1 = instructionList.getVariable(ins.getVariable1Argument());
        double variable2 = instructionList.getVariable(ins.getVariable2Argument());
        if(Double.compare(variable1, variable2) > 0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableLessThanVariable ins) {
        double variable1 = instructionList.getVariable(ins.getVariable1Argument());
        double variable2 = instructionList.getVariable(ins.getVariable2Argument());
        if(Double.compare(variable1, variable2) < 0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableEqualVariable ins) {
        double variable1 = instructionList.getVariable(ins.getVariable1Argument());
        double variable2 = instructionList.getVariable(ins.getVariable2Argument());
        if(0 == Double.compare(variable1, variable2)) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableNotEqualVariable ins) {
        double variable1 = instructionList.getVariable(ins.getVariable1Argument());
        double variable2 = instructionList.getVariable(ins.getVariable2Argument());
        if(0 != Double.compare(variable1, variable2)) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableGreaterThanDouble ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(Double.compare(variable, ins.getDoubleArgument()) > 0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableLessThanDouble ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(Double.compare(variable, ins.getDoubleArgument()) < 0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableEqualDouble ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(0 == Double.compare(variable, ins.getDoubleArgument())) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableNotEqualDouble ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(0 != Double.compare(variable, ins.getDoubleArgument())) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterGreaterThanDouble ins) {
        double register = registers[ins.getRegister()];
        if(Double.compare(register, ins.getDoubleArgument()) > 0)
            jumpTo(ins.getAddress());
    }

    @Override
    public void execute(JumpIfRegisterLessThanDouble ins) {
        double register = registers[ins.getRegister()];
        if(Double.compare(register, ins.getDoubleArgument()) < 0)
            jumpTo(ins.getAddress());
    }

    @Override
    public void execute(JumpIfRegisterEqualDouble ins) {
        double register = registers[ins.getRegister()];
        if(0 == Double.compare(register, ins.getDoubleArgument()))
            jumpTo(ins.getAddress());
    }

    @Override
    public void execute(JumpIfRegisterNotEqualDouble ins) {
        double register = registers[ins.getRegister()];
        if(0 != Double.compare(register, ins.getDoubleArgument()))
            jumpTo(ins.getAddress());
    }

    @Override
    public void execute(JumpIfRegisterEqualZero ins) {
        double register = registers[ins.getRegister()];
        if (register == 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterNotEqualZero ins) {
        double register = registers[ins.getRegister()];
        if(register != 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterGreaterThanZero ins) {
        double register = registers[ins.getRegister()];
        if(register > 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfRegisterLessThanZero ins) {
        double register = registers[ins.getRegister()];
        if(register < 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableEqualZero ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(variable == 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableNotEqualZero ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(variable != 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableGreaterThanZero ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(variable > 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(JumpIfVariableLessThanZero ins) {
        double variable = instructionList.getVariable(ins.getVariableArgument());
        if(variable < 0.0) {
            jumpTo(ins.getAddress());
        }
    }

    @Override
    public void execute(NaturalLogarithmOfData ins) {
        registers[ins.getRegister()] = Math.log(dataRegInstructionGetTrainingPriceData(ins));
   }

    @Override
    public void execute(NaturalLogarithmOfRegister ins) {
        double value = Math.log(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(NaturalLogarithmOfVariable ins) {
        double value = Math.log(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(NaturalLogarithm10OfData ins) {
        registers[ins.getRegister()] = Math.log10(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(NaturalLogarithm10OfRegister ins) {
        double value = Math.log10(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(NaturalLogarithm10OfVariable ins) {
        double value = Math.log10(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(SqRootOfRegister ins) {
        double value = Math.pow(registers[ins.getRegister2()], 0.5);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(SqRootOfVariable ins) {
        double value = Math.pow(instructionList.getVariable(ins.getVariable2Argument()), 0.5);
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(CbRootOfRegister ins) {
        double value = Math.cbrt(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(CbRootOfVariable ins) {
        double value = Math.cbrt(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(SumOfColumn ins) {
        int column = fixColumn(ins.getRegister1());
        int length = fixLength(registers[ins.getRegister2()]);
        registers[0] = getSum(column,length);
    }

    @Override
    public void execute(AverageOfColumn ins) {
        int column = fixColumn(registers[ins.getRegister1()]);
        int length = fixLength(registers[ins.getRegister2()]);
        double sum = getSum(column, length);
        registers[0] = sum / length;
    }


    private double getSum(int column, int length) {
        double sum = 0;
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        for(int i = 0; i < length; i++) {
            sum += data.getTrainingPriceData(column,i);
        }
        return sum;
    }

    @Override
    public void execute(PercentileOfColumn ins) {
        int column = fixColumn(registers[ins.getRegister1()]);
        int length = fixLength(registers[ins.getRegister2()]);
        if(length == 0) {
            return;
        }
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        double[] priceDataList = new double[length];
        for(int i = 0; i < length; i++) {
            priceDataList[i] = data.getTrainingPriceData(column,i);
        }
        Arrays.sort(priceDataList);
        int percentileIndex = (int)Math.ceil(((double)ins.getPercentile() / (double)100) * (double)priceDataList.length);
        registers[0] = priceDataList[percentileIndex-1];
    }
 
    @Override
    public void execute(FibonacciOfColumn ins) {
        int column = fixColumn(registers[ins.getRegister1()]);
        int length = Math.max(2, fixLength(registers[ins.getRegister2()]));
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        
        double[] priceDataList = new double[length];
        priceDataList[0] = data.getTrainingPriceData(column,0);
        priceDataList[1] = data.getTrainingPriceData(column,1);
        for(int i = 2; i < length; i++) {
            priceDataList[i] =  priceDataList[i-1] + priceDataList[i-2];
        }
        registers[0] = priceDataList[length-1];
    }

    @Override
    public void execute(SwapVariables ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), var2);
        instructionList.setVariable(ins.getVariable2Argument(), var1);
    }

    @Override
    public void execute(SubtractVariableFromRegister ins) {
        int reg = ins.getRegister();
        registers[reg] -= instructionList.getVariable(ins.getVariableArgument());
    }

    @Override
    public void execute(DivideRegisterByDouble ins) {
        int reg = ins.getRegister();
        registers[reg] /= ins.getDoubleArgument();
    }

    @Override
    public void execute(MultiplyRegisterByDouble ins) {
        int reg = ins.getRegister();
        registers[reg] *= ins.getDoubleArgument();
    }

    @Override
    public void execute(DivideVariableByDouble ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = var / ins.getDoubleArgument();
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(MultiplyVariableByDouble ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = var * ins.getDoubleArgument();
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(ZeroOutVariable ins) {
        instructionList.setVariable(ins.getVariableArgument(), 0.0);
    }

    @Override
    public void execute(IncrementVariable ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        var++;
        instructionList.setVariable(ins.getVariableArgument(), var);
    }

    @Override
    public void execute(DecrementVariable ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        var--;
        instructionList.setVariable(ins.getVariableArgument(), var);
    }

    @Override
    public void execute(AddDoubleToVariable ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = var + ins.getDoubleArgument();
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(SubtractDoubleFromVariable ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = var - ins.getDoubleArgument();
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(AddRegisterToVariable ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        int register = ins.getRegister();
        double result = var + registers[register];
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(SubtractRegisterFromVariable ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        int register = ins.getRegister();
        double result = var - registers[register];
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(AddVariableToVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        double result = var1 + var2;
        instructionList.setVariable(ins.getVariable1Argument(), result);
    }

    @Override
    public void execute(SubtractVariableFromVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        double result = var1 - var2;
        instructionList.setVariable(ins.getVariable1Argument(),result);
    }

    @Override
    public void execute(MoveVariableToVariable ins) {
        double var = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(),var);
    }

    @Override
    public void execute(HighestOfColumn ins) {
        int column = fixColumn(ins.getRegister1());
        int length = fixLength(registers[ins.getRegister2()]);
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        double highest = data.getTrainingPriceData(column,0);
        for(int i = 1; i < length; i++) {
            double check = data.getTrainingPriceData(column,i);
            if(check > highest) {
                highest = check;
            }
        }
        registers[0] = highest;
    }

    @Override
    public void execute(LowestOfColumn ins) {
        int column = fixColumn(registers[ins.getRegister1()]);
        int length = fixLength(registers[ins.getRegister2()]);
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        double lowest = data.getTrainingPriceData(column,0);
        for(int i = 1; i < length; i++) {
            double check = data.getTrainingPriceData(column,i);
            if(check < lowest) {
                lowest = check;
            }
        }
        registers[0] = lowest;
    }

    @Override
    public void execute(AbsoluteOfData ins) {
        registers[ins.getRegister()] = Math.abs(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(AbsoluteOfRegister ins) {
        double value = Math.abs(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(AbsoluteOfVariable ins) {
        double value = Math.abs(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(NegationOfData ins) {
        registers[ins.getRegister()] = dataRegInstructionGetTrainingPriceData(ins) * -1;
    }

    @Override
    public void execute(NegationOfRegister ins) {
        double value = registers[ins.getRegister2()] * -1;
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(NegationOfVariable ins) {
        double value = instructionList.getVariable(ins.getVariable2Argument()) * -1;
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(CeilingOfData ins) {
        registers[ins.getRegister()] = Math.ceil(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(CeilingOfRegister ins) {
        double value = Math.ceil(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(CeilingOfVariable ins) {
        double value = Math.ceil(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(FloorOfData ins) {
        registers[ins.getRegister()] = Math.floor(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(FloorOfRegister ins) {
        double value = Math.floor(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(FloorOfVariable ins) {
        double value = Math.round(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(RoundOfData ins) {
        registers[ins.getRegister()] = Math.round(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(RoundOfRegister ins) {
        double value = Math.round(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(RoundOfVariable ins) {
        double value = Math.floor(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(MaximumOfRegisterAndDouble ins) {
        int reg = ins.getRegister();
        registers[reg] = Math.max(registers[reg], ins.getDoubleArgument());
    }

    @Override
    public void execute(MaximumOfRegisterAndRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] = Math.max(registers[reg1], registers[reg2]);
    }

    @Override
    public void execute(MaximumOfRegisterAndVariable ins) {
        int reg = ins.getRegister();
        registers[reg] = Math.max(registers[reg], instructionList.getVariable(ins.getVariableArgument()));
    }

    @Override
    public void execute(MaximumOfVariableAndDouble ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = Math.max(var, ins.getDoubleArgument());
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(MaximumOfVariableAndVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), Math.max(var1,  var2));
    }

    @Override
    public void execute(MinimumOfRegisterAndDouble ins) {
        int reg = ins.getRegister();
        registers[reg] = Math.min(registers[reg], ins.getDoubleArgument());
    }

    @Override
    public void execute(MinimumOfRegisterAndRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] = Math.min(registers[reg1], registers[reg2]);
    }

    @Override
    public void execute(MinimumOfRegisterAndVariable ins) {
        int reg = ins.getRegister();
        registers[reg] = Math.min(registers[reg], instructionList.getVariable(ins.getVariableArgument()));
    }

    @Override
    public void execute(MinimumOfVariableAndDouble ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = Math.min(var, ins.getDoubleArgument());
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(MinimumOfVariableAndVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), Math.min(var1,  var2));
    }

    @Override
    public void execute(ModulusOfRegisterAndDouble ins) {
        int reg = ins.getRegister();
        registers[reg] = registers[reg] % ins.getDoubleArgument();
    }

    @Override
    public void execute(ModulusOfRegisterAndRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] = registers[reg1] % registers[reg2];
    }

    @Override
    public void execute(ModulusOfRegisterAndVariable ins) {
        int reg = ins.getRegister();
        registers[reg] = registers[reg] % instructionList.getVariable(ins.getVariableArgument());
    }

    @Override
    public void execute(ModulusOfVariableAndDouble ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = var % ins.getDoubleArgument();
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(ModulusOfVariableAndVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), var1 % var2);
    }

    @Override
    public void execute(HypotOfRegisterAndDouble ins) {
        int reg = ins.getRegister();
        registers[reg] = Math.hypot(registers[reg], ins.getDoubleArgument());
    }

    @Override
    public void execute(HypotOfRegisterAndRegister ins) {
        int reg1 = ins.getRegister1();
        int reg2 = ins.getRegister2();
        registers[reg1] = Math.hypot(registers[reg1], registers[reg2]);
    }

    @Override
    public void execute(HypotOfRegisterAndVariable ins) {
        int reg = ins.getRegister();
        registers[reg] = Math.hypot(registers[reg], instructionList.getVariable(ins.getVariableArgument()));
    }

    @Override
    public void execute(HypotOfVariableAndDouble ins) {
        double var = instructionList.getVariable(ins.getVariableArgument());
        double result = Math.hypot(var, ins.getDoubleArgument());
        instructionList.setVariable(ins.getVariableArgument(), result);
    }

    @Override
    public void execute(HypotOfVariableAndVariable ins) {
        double var1 = instructionList.getVariable(ins.getVariable1Argument());
        double var2 = instructionList.getVariable(ins.getVariable2Argument());
        instructionList.setVariable(ins.getVariable1Argument(), Math.hypot(var1,  var2));
    }

    @Override
    public void execute(CosineOfData ins) {
        registers[ins.getRegister()] = Math.cos(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(CosineOfRegister ins) {
        double value = Math.cos(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(CosineOfVariable ins) {
        double value = Math.cos(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(ArccosineOfData ins) {
        registers[ins.getRegister()] = Math.acos(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(ArccosineOfRegister ins) {
        double value = Math.acos(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(ArccosineOfVariable ins) {
        double value = Math.acos(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(SineOfData ins) {
        registers[ins.getRegister()] = Math.sin(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(SineOfRegister ins) {
        double value = Math.sin(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(SineOfVariable ins) {
        double value = Math.sin(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(ArcsineOfData ins) {
        registers[ins.getRegister()] = Math.asin(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(ArcsineOfRegister ins) {
        double value = Math.asin(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(ArcsineOfVariable ins) {
        double value = Math.asin(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(TangentOfData ins) {
        registers[ins.getRegister()] = Math.tan(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(TangentOfRegister ins) {
        double value = Math.tan(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(TangentOfVariable ins) {
        double value = Math.tan(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(ArctangentOfData ins) {
        registers[ins.getRegister()] = Math.atan(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(ArctangentOfRegister ins) {
        double value = Math.atan(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(ArctangentOfVariable ins) {
        double value = Math.atan(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }
    
    @Override
    public void execute(HyperbolicSineOfData ins) {
        registers[ins.getRegister()] = Math.sinh(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(HyperbolicSineOfRegister ins) {
        double value = Math.sinh(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(HyperbolicSineOfVariable ins) {
        double value = Math.sinh(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(HyperbolicCosineOfData ins) {
        registers[ins.getRegister()] = Math.cosh(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(HyperbolicCosineOfRegister ins) {
        double value = Math.cosh(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(HyperbolicCosineOfVariable ins) {
        double value = Math.cosh(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    @Override
    public void execute(HyperbolicTangentOfData ins) {
        registers[ins.getRegister()] = Math.tanh(dataRegInstructionGetTrainingPriceData(ins));
    }

    @Override
    public void execute(HyperbolicTangentOfRegister ins) {
        double value = Math.tanh(registers[ins.getRegister2()]);
        registers[ins.getRegister1()] = value;
    }

    @Override
    public void execute(HyperbolicTangentOfVariable ins) {
        double value = Math.tanh(instructionList.getVariable(ins.getVariable2Argument()));
        instructionList.setVariable(ins.getVariable1Argument(),value);
    }

    private double dataRegInstructionGetTrainingPriceData(DataRegInstruction ins) {
        int column = fixColumn(ins.getDataColumnIndex());
        int offset = fixOffset(ins.getDataOffsetIndex());
        if(!columnAccess.setAccessedColumn(column)) throw new NotEnoughDataException();
        return data.getTrainingPriceData(column,offset);
    }

    private int getRelativeOffset(DataInstruction ins) {
        double value = instructionList.getVariable(ins.getDataOffsetIndex());
        return fixOffset(value);
    }

    private int fixOffset(double value) {
        return (int)Math.abs(value % maximumDataOffset);
    }
    
    private int fixLength(double value) {
        return Math.max(1, fixOffset(value));
    }
    
    private int fixColumn(double value) {
        return ignoreColumns + (int)Math.abs(value % (dataColumns - ignoreColumns));
    }
}
