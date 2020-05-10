package org.arithmetic;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Arithmetic {
    public static void main(String[] args) {
        List<Question> questionsList = OperandsCollection.generate(10, 0, 10)
                .stream()
                .map(operands -> new Statement(operands, Operation.multiply))
                .map(Question::new)
                .collect(toList());
        Stream<Result> resultStream = IntStream.range(0, 10)
                .boxed()
                .map(i -> questionsList.get(i).ask(i + 1));
        Statistics statistics = new Statistics(resultStream);
        statistics.print();
    }
}
