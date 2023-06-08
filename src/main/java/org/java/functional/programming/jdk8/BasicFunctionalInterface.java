package org.java.functional.programming.jdk8;

import org.java.functional.programming.common.BinaryIntOpInput;

import java.util.function.Function;

public class BasicFunctionalInterface {
    public BinaryIntOp add() {
        return (a, b) -> a + b;
    }

    public BinaryIntOp subtract() {
        return (a, b) -> a - b;
    }

    public BinaryIntOp multiply() {
        return (a, b) -> a * b;
    }

    public BinaryIntOp divide() {
        return (a, b) -> a / b;
    }

    public int compute(Function<BinaryIntOpInput, Integer> function, BinaryIntOpInput input) {
        return function.apply(input);
    }

    @FunctionalInterface
    interface BinaryIntOp {
        int perform(int a, int b);
    }
}

