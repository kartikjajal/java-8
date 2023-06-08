package org.java.functional.programming.jdk8;

import org.java.functional.programming.common.BinaryIntOpInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

public class BasicFunctionalInterfaceTest {

    private static final BasicFunctionalInterface subject = new BasicFunctionalInterface();

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of(subject.add(), 5, 7, 12),
                Arguments.of(subject.subtract(), 10, 7, 3),
                Arguments.of(subject.multiply(), 10, 3, 30),
                Arguments.of(subject.divide(), 10, 2, 5)
        );
    }

    private static Stream<Arguments> getComputeData() {

        Function<BinaryIntOpInput, Integer> multiply = (input) -> input.getA() * input.getB();
        Function<BinaryIntOpInput, Integer> division = (input) -> input.getA() / input.getB();
        Function<BinaryIntOpInput, Integer> plus = (input) -> input.getA() + input.getB();
        Function<BinaryIntOpInput, Integer> minus = (input) -> input.getA() - input.getB();
        return Stream.of(
                Arguments.of(multiply, 5, 5, 25),
                Arguments.of(division, 5, 5, 1),
                Arguments.of(plus, 5, 5, 10),
                Arguments.of(minus, 5, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Perform : ")
    void testFunctionSum(BasicFunctionalInterface.BinaryIntOp binaryIntOp, int a, int b, int expected) {
        int actual = binaryIntOp.perform(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getComputeData")
    void test_compute(Function<BinaryIntOpInput, Integer> function, int a, int b, int expected) {
        int actual = subject.compute(function,
                BinaryIntOpInput.builder()
                                .a(a)
                                .b(b)
                                .build());
        Assertions.assertEquals(expected, actual);
    }
}
