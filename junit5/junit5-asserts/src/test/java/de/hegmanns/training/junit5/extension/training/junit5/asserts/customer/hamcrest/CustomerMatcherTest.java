package de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.Customer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerMatcherTest {

    Customer anyCustomer;

    @BeforeEach
    private void prepareCustomer() {
        anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));
    }

    @Test
    @Disabled("enable for demonstration")
    public void customerWithCustomMatcherCheckAge() {

        MatcherAssert.assertThat(anyCustomer, CustomerMatcher.hasAge(52));
    }

    @Test
    @Disabled("enable for demonstration")
    public void customerWithCustomMatcherCheckFirstName() {

        MatcherAssert.assertThat(anyCustomer, CustomerMatcher.hasFirstName("willi"));
    }
}
