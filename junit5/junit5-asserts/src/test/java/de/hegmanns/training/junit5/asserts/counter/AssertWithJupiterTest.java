package de.hegmanns.training.junit5.asserts.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertWithJupiterTest extends CommonAssertTest{

    @Test
    public void incrementIncreasesCounterValue() {
        numberCounter.increment();

        Assertions.assertEquals(1, numberCounter.getValue());
    }

    @Test
    public void incrementBoundedCounterIncreasesCounterValue() {
        boundedCounter.increment();

        Assertions.assertEquals(1, boundedCounter.getValue());
    }

    @Test
    public void decrementBoundedCounterThrowsException() {
        Assertions.assertThrows(BoundedCounterException.class, () -> {
            boundedCounter.decrement();
        });
    }

    @Test
    public void decrementCounterReducedCounterValue() {
        numberCounter.decrement();

        Assertions.assertEquals(-1, numberCounter.getValue());
    }

    @Test
    public void boundedCounterIsInitialized() {
        Assertions.assertAll(
                () -> {Assertions.assertEquals(0, boundedCounter.getValue());},
                () -> {Assertions.assertEquals(0, boundedCounter.getMinimalValue());},
                () -> {Assertions.assertEquals(10, boundedCounter.getMaximumValue());}
        );
    }
}
