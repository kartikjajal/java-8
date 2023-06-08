package org.java.functional.programming.example4;

import java.util.stream.IntStream;

public class ParallelStream {
    public Long sum(IntStream intStream) {
        return intStream
                .parallel()
                .boxed()
                .filter(i -> i % 2 == 0)
                .mapToLong(Integer::intValue)
                .sum();
    }
}
