package de.hegmanns.training.junit5.extension.training.junit5.practice.task12;

import org.assertj.core.api.AbstractAssert;
import practice.task04.Counter;

public class CounterAssertion extends AbstractAssert<CounterAssertion, Counter> {

    public CounterAssertion(Counter counter){
        super(counter, CounterAssertion.class);
    }

    public static CounterAssertion assertThat(Counter counter) {
        return new CounterAssertion(counter);
    }

    public void lessThan(Counter other) {
        isNotNull();

        if (!(actual.getValue() < other.getValue())) {
            failWithMessage("\nCounter <%s> with value <%d> is not less than <%s> with value <%d>", actual, actual.getValue(), other, other.getValue());
        }

    }
}
