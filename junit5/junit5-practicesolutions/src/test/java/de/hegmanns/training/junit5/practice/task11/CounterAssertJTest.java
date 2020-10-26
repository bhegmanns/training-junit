package de.hegmanns.training.junit5.practice.task11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.task04.Counter;

public class CounterAssertJTest {

    private Counter counter = new Counter();

    @Test
    public void oneTimeIncrementResultInOneOperation() {
        counter.increment();

        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countOperations", 1);
//        Assertions.assertEquals(1, counter.getCountOperations());
    }

    @Test
    public void oneTimeDecrementResultInOneOperation() {
        counter.decrement();

        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countOperations", 1);
//        Assertions.assertEquals(1, counter.getCountOperations());
    }

    @Test
    public void twoTimesIncrementResultInTwoOperation() {
        counter.increment();
        counter.increment();

        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countOperations", 2);
        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countIncrements", 2);
        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("value", 2);
//        Assertions.assertEquals(2, counter.getCountOperations());
//        Assertions.assertEquals(2, counter.getCountIncrements());
//        Assertions.assertEquals(2, counter.getValue());
    }

    @Test
    public void twoTimesIncrementAndTwoTimesDecrementResultInTwoOperation() {
        counter.increment();
        counter.increment();
        counter.decrement();
        counter.decrement();

        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countOperations", 4);
        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countIncrements", 2);
        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("countDecrements", 2);
        org.assertj.core.api.Assertions.assertThat(counter)
                .hasFieldOrPropertyWithValue("value", 0);

//        Assertions.assertEquals(4, counter.getCountOperations());
//        Assertions.assertEquals(2, counter.getCountIncrements());
//        Assertions.assertEquals(2, counter.getCountDecrements());
//        Assertions.assertEquals(0, counter.getValue());
    }
}
