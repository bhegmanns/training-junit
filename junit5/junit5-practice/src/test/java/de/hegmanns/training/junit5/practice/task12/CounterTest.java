package de.hegmanns.training.junit5.practice.task12;

import de.hegmanns.training.junit5.practice.task04.Counter;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;

public class CounterTest {

    public void oneIncrementBefore() {
        Counter firstCounter = new Counter();
        Counter secondCounter = new Counter();

        firstCounter.increment();
        secondCounter.increment();
        secondCounter.increment();

        Assertions.assertTrue(firstCounter.getValue() < secondCounter.getValue());
    }
}
