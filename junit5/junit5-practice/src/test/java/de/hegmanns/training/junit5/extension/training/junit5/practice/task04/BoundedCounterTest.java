package de.hegmanns.training.junit5.extension.training.junit5.practice.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoundedCounterTest {

    @Test
    public void boundedCounterIncrementsBetweenHisBounds() {
        BoundedCounter counter = new BoundedCounter(10, 0, 20);

        int currentValue = counter.getValue();

        Assertions.assertNotEquals(currentValue, counter.increment());
    }

    @Test
    public void boundedCounterIncrementsByOne() {
        int initialValue = 10;
        BoundedCounter counter = new BoundedCounter(10, 0, 20);

        Assertions.assertEquals(initialValue+1, counter.increment());
    }

    @Test
    public void boundedCounterDoesntIncrementAboveMaximum() {
        int initialValue = 10;
        BoundedCounter counter = new BoundedCounter(10, 0, 20);

        for (int i = 0; i < 100; i++) {
            counter.increment();
        }
        Assertions.assertEquals(20, counter.getValue());
    }

    @Test
    public void boundedCounterWorksPolymorphic() {
        int initialValue = 10;
        Counter counter = new BoundedCounter(10, 0, 20);

        for (int i = 0; i < 100; i++) {
            counter.increment();
        }
        Assertions.assertEquals(20, counter.getValue());
    }
}
