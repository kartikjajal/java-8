package org.java.functional.programming.example1;

import java.util.function.Function;

public class Functional1 {
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

    public int compute(Function<BinaryIntOpInput, Integer> function, BinaryIntOpInput input){
        return function.apply(input);
    }

    @FunctionalInterface
    interface BinaryIntOp {
        public int perform(int a, int b);
    }
}

