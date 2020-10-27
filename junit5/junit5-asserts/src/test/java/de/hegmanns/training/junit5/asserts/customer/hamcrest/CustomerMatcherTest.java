package de.hegmanns.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerMatcherTest {

    @Test
    public void customerWithMatcher() {

        Customer anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));

        MatcherAssert.assertThat(anyCustomer, CustomerMatcher.hasAge(53));
        MatcherAssert.assertThat(anyCustomer, CustomerMatcher.hasFirstName("willi"));

    }
}
