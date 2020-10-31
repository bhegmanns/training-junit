package de.hegmanns.training.junit5.extension.training.junit5.practice.task12;

import org.junit.jupiter.api.Test;
import practice.task04.Counter;

public class CounterTest {

    @Test
    public void oneIncrementBefore() {
        Counter firstCounter = new Counter();
        Counter secondCounter = new Counter();

        firstCounter.increment();
        secondCounter.increment();
        secondCounter.increment();

//        Assertions.assertTrue(firstCounter.getValue() < secondCounter.getValue());
        CounterAssertion.assertThat(firstCounter).lessThan(secondCounter);
    }
}
