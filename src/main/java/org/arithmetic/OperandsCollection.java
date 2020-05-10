package org.arithmetic;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperandsCollection {
    private static final Random r = new Random();
    private final Stream<ImmutablePair<Integer, Integer>> operands;

    private OperandsCollection(Stream<ImmutablePair<Integer, Integer>> operands) {
        this.operands = operands;
    }

    public static OperandsCollection generate(int count, int lowerBound, int upperBound) {
        Stream<ImmutablePair<Integer, Integer>> operands = IntStream.range(0, count).boxed().map(_1 -> generatePair(lowerBound, upperBound));
        return new OperandsCollection(operands);
    }

    private static ImmutablePair<Integer, Integer> generatePair(int lowerBound, int upperBound) {
        return ImmutablePair.of(generateInt(lowerBound, upperBound), generateInt(lowerBound, upperBound));
    };

    private static int generateInt(int lowerBound, int upperBound) {
        return r.nextInt(upperBound) + lowerBound;
    }

    public Stream<ImmutablePair<Integer, Integer>> stream() {
        return operands;
    }
}
