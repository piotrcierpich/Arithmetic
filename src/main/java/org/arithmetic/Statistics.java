package org.arithmetic;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Statistics {
    private final Stream<Result> resultStream;

    public Statistics(Stream<Result> resultStream) {
        this.resultStream = resultStream;
    }

    public void print() {
        List<Result> incorrectResponses = this.resultStream.filter(Result::isIncorrect).collect(toList());
        System.out.println(String.format("Błędne odpowiedzi (%s):", incorrectResponses.size()));
        incorrectResponses.forEach(r -> r.print(System.out));
    }
}
