package de.hegmanns.training.junit5.practice.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoundedCounterTest {

    private BoundedCounter anyCounter;
    private int initialValue;


    @BeforeEach
    public void beforeAnyTest() {
        initialValue = 10;
        anyCounter = new BoundedCounter(initialValue, 0, 20);
    }

    @Test
    public void boundedCounterIncrementsBetweenHisBounds() {
//        BoundedCounter counter = new BoundedCounter(10, 0, 20);

        int currentValue = anyCounter.getValue();

        Assertions.assertNotEquals(currentValue, anyCounter.increment());
    }

    @Test
    public void boundedCounterIncrementsByOne() {
//        int initialValue = 10;
//        BoundedCounter counter = new BoundedCounter(10, 0, 20);

        Assertions.assertEquals(initialValue+1, anyCounter.increment());
    }

    @Test
    public void boundedCounterDoesntIncrementAboveMaximum() {
//        int initialValue = 10;
//        BoundedCounter counter = new BoundedCounter(10, 0, 20);

        for (int i = 0; i < 100; i++) {
            anyCounter.increment();
        }
        Assertions.assertEquals(20, anyCounter.getValue());
    }

    @Test
    public void boundedCounterWorksPolymorphic() {
//        int initialValue = 10;
//        Counter counter = new BoundedCounter(10, 0, 20);

        for (int i = 0; i < 100; i++) {
            anyCounter.increment();
        }
        Assertions.assertEquals(20, anyCounter.getValue());
    }
}
