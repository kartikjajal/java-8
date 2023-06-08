package org.java.functional.programming.jdk8;

import org.java.functional.programming.jdk8.StreamOfOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StreamOfOperationsTest {
    private final StreamOfOperations subject = new StreamOfOperations();

    @Test
    void test_streamOfString() {
        String expected = "human,moon,sun";
        String actual = subject.streamOfString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_streamOfInt() {
        int expected = 90;
        int actual = subject.streamOfInt();
        Assertions.assertEquals(expected, actual);
    }
}
