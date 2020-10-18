package de.hegmanns.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerWithHamcrestFeatureMatcherTest {

    @Test
    public void customerWithMatcher() {

        Customer anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));

        Assertions.assertAll(
                () -> MatcherAssert.assertThat(anyCustomer, CustomerFeatureMatcher.age(Matchers.is(53))),
                () -> MatcherAssert.assertThat(anyCustomer, CustomerFeatureMatcher.age(Matchers.lessThan(60))),
                () -> MatcherAssert.assertThat(anyCustomer, CustomerFeatureMatcher.age(Matchers.greaterThan(18)))
        );
    }
}
