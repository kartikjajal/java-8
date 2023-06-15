package org.java.functional.programming.jdk8;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierConsumerTest {
    private final SupplierConsumer subject = new SupplierConsumer();

    @Test
    void test_doubledAndSquaredUsingString() {
        Double actual = subject.doubledAndSquared("5");
        assertThat(actual)
                .isEqualTo(100);
    }

    @Test
    void test_squaredAndDouble() {
        Double actual = subject.doubledAndSquared(5d);
        assertThat(actual)
                .isEqualTo(100);
    }

    @Test
    void test_doubledAndSquaredUsingDouble() {
        Double actual = subject.squaredAndDouble(5d);
        assertThat(actual)
                .isEqualTo(50);
    }

    @Test
    void test_consumer_supplier(){
        Supplier<Collection<String>> listSupplier = SupplierConsumerTest::supplyData;
        Consumer<Collection<String>> stringConsumer = (l)-> l.stream()
                                                             .map(String::toLowerCase)
                                                             .forEach(System.out::println);
        stringConsumer.accept(listSupplier.get());
    }

    private static Collection<String> supplyData(){
        return List.of("Apple","CaT","DOG","ORAngE");
    }
}
