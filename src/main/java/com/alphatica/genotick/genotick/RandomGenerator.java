package com.alphatica.genotick.genotick;

import org.uncommons.maths.random.SecureRandomSeedGenerator;
import org.uncommons.maths.random.SeedException;
import org.uncommons.maths.random.SeedGenerator;
import org.uncommons.maths.random.XORShiftRNG;

import java.util.Random;

public class RandomGenerator {
    public static Random assignRandom() {
        SeedGenerator seedGenerator = new SecureRandomSeedGenerator();
        try {
            return new XORShiftRNG(seedGenerator);
        } catch (SeedException e) {
            throw new RuntimeException("Cannot initial random.", e);
        }
    }
}
