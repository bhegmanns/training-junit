package de.hegmanns.training.junit5.extension.training.junit5.practice.task17;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoundedCounterTest {
    @Test
    public void boundedCounterDoesntIncrementAboveMaximum() {
        int initialValue = 10;
        BoundedCounter counter = new BoundedCounter(initialValue, 0, 20);

        for (int i = 0; i < 11; i++) {
            counter.increment();
        }
        Assertions.assertEquals(20, counter.getValue());
    }
}
