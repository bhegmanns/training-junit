package de.hegmanns.training.junit5.extension.training.junit5.practice.task09;

import org.junit.jupiter.api.*;
import practice.task04.BoundedCounter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoundedCounterTest {

//    @Test
//    public void boundedCounterDoesntIncrementAboveMaximum() {
//        int initialValue = 10;
//        BoundedCounter counter = new BoundedCounter(initialValue, 0, 20);
//
//        for (int i = 0; i < 100; i++) {
//            counter.increment();
//        }
//        Assertions.assertEquals(20, counter.getValue());
//    }

    BoundedCounter counter;
    int initialValue;
    int maximum;
    int expectedCountOfIncrementsUntilCounterIsBounded;
    @BeforeAll
    public void oneTimeInitialization() {
        initialValue = 10;
        maximum = 20;
        expectedCountOfIncrementsUntilCounterIsBounded = maximum - initialValue;

        counter = new BoundedCounter(initialValue, 0, maximum);
    }

    @RepeatedTest(100)
    public void boundedCounterDoesntIncrementAboveMaximum(RepetitionInfo repetitionInfo) {
        counter.increment();

        Assertions.assertEquals(repetitionInfo.getCurrentRepetition()<= expectedCountOfIncrementsUntilCounterIsBounded ?repetitionInfo.getCurrentRepetition()+initialValue : maximum, counter.getValue());
    }


}
