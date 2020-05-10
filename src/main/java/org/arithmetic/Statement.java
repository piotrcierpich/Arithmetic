package org.arithmetic;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class Statement {
    private final ImmutablePair<Integer, Integer> operands;
    private final Operation operation;
    private Integer expectedResult;

    public Statement(ImmutablePair<Integer, Integer> operands, Operation operation) {
        this.operands = operands;
        this.operation = operation;
        calculateExpected();
    }

    private void calculateExpected() {
        if(operation == Operation.multiply) {
            expectedResult = operands.left * operands.right;
        }
    }

    public String format(Question question) {
        return question.format(operands.left, operands.right);
    }

    public boolean isResultIncorrect(Integer actualResult) {
        return !expectedResult.equals(actualResult);
    }
}
