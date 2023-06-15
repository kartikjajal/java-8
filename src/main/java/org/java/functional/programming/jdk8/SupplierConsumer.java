package org.java.functional.programming.jdk8;

import java.util.function.Function;

public class SupplierConsumer {

    private static final Function<Double, Double> doubled = (d) -> d * 2;

    private static final Function<Double, Double> squared = (d) -> d * d;

    private static final Function<String, Double> stringToDouble = Double::valueOf;

    public Double doubledAndSquared(Double value) {
        return doubled
                .andThen(squared)
                .apply(value);
    }

    public Double squaredAndDouble(Double value) {
        return doubled
                .compose(squared)
                .apply(value);
    }

    public Double doubledAndSquared(String value) {
        return stringToDouble
                .andThen(doubled)
                .andThen(squared)
                .apply(value);
    }
}
