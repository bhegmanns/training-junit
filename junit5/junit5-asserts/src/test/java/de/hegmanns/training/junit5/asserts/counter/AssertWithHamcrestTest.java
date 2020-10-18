package de.hegmanns.training.junit5.asserts.counter;

import org.hamcrest.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertWithHamcrestTest extends CommonAssertTest{

    @Test
    public void incrementIncreasesCounterValue() {
        numberCounter.increment();

        MatcherAssert.assertThat(numberCounter, Matchers.hasProperty("value", Matchers.is(1)));
    }

    @Test
    public void incrementBoundedCounterIncreasesCounterValue() {
        boundedCounter.increment();

        MatcherAssert.assertThat(boundedCounter, Matchers.hasProperty("value", Matchers.is(1)));
        MatcherAssert.assertThat(boundedCounter.getValue(), Matchers.is(Matchers.lessThanOrEqualTo(1)));
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

        MatcherAssert.assertThat(numberCounter, Matchers.hasProperty("value", Matchers.is(-1)));
    }

//    @Test
//    public void boundedCounterIsInitialized() {
//        BoundedNumericCounter exampleCounter = BoundedNumericCounter.BoundedCounterFl.create(0).withMaxBound(10).withMinBound(0).create();
//
//        MatcherAssert.assertThat(boundedCounter, Matchers.samePropertyValuesAs(exampleCounter));
//    }

    @Test
    public void workingWithValueMatcher() {
        MatcherAssert.assertThat(numberCounter, value(Matchers.is(0)));
    }

    @Test
    public void workingWithCustomMatcher() {
        numberCounter.increment();
        numberCounter.increment();
        numberCounter.increment();

        NumericCounter exampleCounter = NumericCounter.CounterFl.create(3).create();

        MatcherAssert.assertThat(numberCounter, CounterHamcrestMatcher.sameValue(exampleCounter));
    }

    @Test
    public void boundedCounterMatchingWithCustomerMatcher() {
        boundedCounter.increment();
        boundedCounter.increment();
        boundedCounter.increment();

        BoundedNumericCounter exampleCounter = BoundedNumericCounter.BoundedCounterFl.create(3).withMinBound(0).withMaxBound(10).create();

        MatcherAssert.assertThat(boundedCounter, CounterHamcrestMatcher.matches(exampleCounter));
    }



    private Matcher<NumericCounter> value(Matcher<? super Integer> intMatcher){
        return new FeatureMatcher<NumericCounter, Integer>(intMatcher, "value of Counter that", "value") {
            @Override
            protected Integer featureValueOf(NumericCounter actual) {
                return actual.getValue();
            }
        };
    }

}
