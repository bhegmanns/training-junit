package de.hegmanns.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import java.time.LocalDate;
import java.time.Period;

public class CustomerFeatureMatcher {

    public static Matcher<Customer> age(Matcher<? super Integer> intMatcher) {
        return new FeatureMatcher<Customer, Integer>(intMatcher, "age of customer", "age") {
            @Override
            protected Integer featureValueOf(Customer actual) {
                LocalDate dayOfBirth = actual.getBirthDay();
                LocalDate today = LocalDate.now();

                Period until = dayOfBirth.until(today);

                return until.getYears();
            }
        };
    }
}
