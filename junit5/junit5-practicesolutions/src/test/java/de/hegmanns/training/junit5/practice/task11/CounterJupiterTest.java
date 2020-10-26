package de.hegmanns.training.junit5.practice.task11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.task04.Counter;

public class CounterJupiterTest {

    private Counter counter = new Counter();

    @Test
    public void oneTimeIncrementResultInOneOperation() {
        counter.increment();

        Assertions.assertEquals(1, counter.getCountOperations());
    }

    @Test
    public void oneTimeDecrementResultInOneOperation() {
        counter.decrement();

        Assertions.assertEquals(1, counter.getCountOperations());
    }

    @Test
    public void twoTimesIncrementResultInTwoOperation() {
        counter.increment();
        counter.increment();

        Assertions.assertEquals(2, counter.getCountOperations());
        Assertions.assertEquals(2, counter.getCountIncrements());
        Assertions.assertEquals(2, counter.getValue());
    }

    @Test
    public void twoTimesIncrementAndTwoTimesDecrementResultInTwoOperation() {
        counter.increment();
        counter.increment();
        counter.decrement();
        counter.decrement();

        Assertions.assertEquals(4, counter.getCountOperations());
        Assertions.assertEquals(2, counter.getCountIncrements());
        Assertions.assertEquals(2, counter.getCountDecrements());
        Assertions.assertEquals(0, counter.getValue());
    }
}
