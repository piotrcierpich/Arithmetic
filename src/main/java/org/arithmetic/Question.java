package org.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question {
    private final BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
    private final Statement statement;
    private final  String text;

    public Question(Statement statement) {
        this.statement = statement;
        text = statement.format(this);
    }

    public Result ask(Integer index) {
        String numberedQuestionText = String.format("%s. %s", index, text);
        System.out.println(numberedQuestionText);
        String response = "";
        try {
            response = inReader.readLine();
            Integer result = Integer.parseInt(response);
            boolean isIncorrect = statement.isResultIncorrect(result);
            return new Result(text, response, isIncorrect);
        } catch (IOException | NumberFormatException e) {
            return new Result(text, response, false);
        }
    }

    public String format(Integer operand1, Integer operand2) {
        return String.format("Ile jest '%s' razy '%s'", operand1, operand2);
    }
}
