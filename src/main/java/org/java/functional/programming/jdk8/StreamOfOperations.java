package org.java.functional.programming.jdk8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfOperations {
    public String streamOfString() {
        return Stream.of("Cat", "Fish", "Dog", "Bird", "Human", "Moon", "Star", "Sun")
                     .filter(s -> s.endsWith("n"))
                     .map(String::toLowerCase)
                     .sorted()
                     .collect(Collectors.joining(","));
    }

    public int streamOfInt() {
        return IntStream.range(1, 20)
                        .filter(i -> (i % 2) == 0)
                        .sum();
    }
}
