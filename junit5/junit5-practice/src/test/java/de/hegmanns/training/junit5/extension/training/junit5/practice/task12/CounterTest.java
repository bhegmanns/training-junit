package de.hegmanns.training.junit5.extension.training.junit5.practice.task12;

import de.hegmanns.training.junit5.extension.training.junit5.practice.task04.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterTest {

    @Test
    public void oneIncrementBefore() {
        Counter firstCounter = new Counter();
        Counter secondCounter = new Counter();

        firstCounter.increment();
        secondCounter.increment();
        secondCounter.increment();

        Assertions.assertTrue(firstCounter.getValue() < secondCounter.getValue());
    }
}
