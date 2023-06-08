package org.java.functional.programming.jdk8;

import org.java.functional.programming.jdk8.ParallelStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamTest {
    private final ParallelStream subject = new ParallelStream();

    private static Stream<Arguments> getTestData() {
        return Stream.of(Arguments.of(IntStream.range(0, 10), 20L),
                Arguments.of(IntStream.of(5, 11, 13, 18, 19, 17), 18L));
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test_parallelStreamSum(IntStream intStream, Long expected) {
        Long actual = subject.sum(intStream);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_verifyCore() {
        int pool = ForkJoinPool.getCommonPoolParallelism();
        Assertions.assertEquals(7, pool);
    }
}
