package de.hegmanns.training.junit5.asserts.counter;

import org.junit.jupiter.api.BeforeEach;

public class CommonAssertTest {

    public NumericCounter numberCounter ;
    public BoundedNumericCounter boundedCounter;

    @BeforeEach
    public void beforeAnyTest() {
        numberCounter = NumericCounter.CounterFl.create(0).create();
        boundedCounter= BoundedNumericCounter.BoundedCounterFl.create(0).withMinBound(0).withMaxBound(10).create();
    }
}
