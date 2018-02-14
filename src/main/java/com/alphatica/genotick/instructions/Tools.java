package com.alphatica.genotick.instructions;

import com.alphatica.genotick.mutator.Mutator;

class Tools {
    static double mutateDouble(double argument, Mutator mutator) {
        return argument == 0 ? limitedRandom(1000, mutator) : mutateArgument(argument, mutator);
    }

    private static double mutateArgument(double argument, Mutator mutator) {
        return argument * limitedRandom(20, mutator);
    }

    private static double limitedRandom(double limit, Mutator mutator) {
        return limit * mutator.getNextDouble();
    }
}
