package de.hegmanns.training.junit5.extension.training.junit5.asserts.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertWithAssertJTest extends CommonAssertTest{

    @Test
    public void incrementIncreasesCounterValue() {
        numberCounter.increment();

        org.assertj.core.api.Assertions.assertThat(numberCounter).hasFieldOrPropertyWithValue("value", 1);
    }

    @Test
    public void incrementBoundedCounterIncreasesCounterValue() {
        boundedCounter.increment();

        org.assertj.core.api.Assertions.assertThat(boundedCounter).hasFieldOrPropertyWithValue("value", 1);
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

        org.assertj.core.api.Assertions.assertThat(numberCounter).hasFieldOrPropertyWithValue("value", -1);
    }

    @Test
    public void boundedCounterIsInitialized() {
        BoundedNumericCounter exampleCounter = BoundedNumericCounter.BoundedCounterFl.create(0).withMaxBound(10).withMinBound(0).create();

        org.assertj.core.api.Assertions.assertThat(boundedCounter).isEqualToComparingFieldByField(exampleCounter);
    }

    @Test
    public void boundedCounterComparingMinAndMax() {
        org.assertj.core.api.Assertions.assertThat(boundedCounter)
                .hasFieldOrPropertyWithValue("minimalValue", 0)
                .hasFieldOrPropertyWithValue("maximumValue", 10)
                .isNotNull();
    }

}
