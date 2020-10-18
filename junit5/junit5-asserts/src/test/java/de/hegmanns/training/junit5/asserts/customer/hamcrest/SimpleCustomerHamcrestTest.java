package de.hegmanns.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SimpleCustomerHamcrestTest {

    @Test
    public void correctAge() {
        Customer anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));

        MatcherAssert.assertThat("customers last name", anyCustomer, Matchers.hasProperty("lastName", Matchers.is("Hegmanns")));
    }
}
