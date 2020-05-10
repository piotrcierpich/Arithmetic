package org.arithmetic;

import java.io.PrintStream;

public class Result {
    private final String questionText;
    private final String response;
    private final boolean isIncorrect;

    public Result(String questionText, String response, boolean isIncorrect) {
        this.questionText = questionText;
        this.response = response;
        this.isIncorrect = isIncorrect;
    }

    public boolean isIncorrect() {
        return isIncorrect;
    }

    public void print(PrintStream out) {
        out.println(String.format("%s: %s", questionText, response));
    }
}
