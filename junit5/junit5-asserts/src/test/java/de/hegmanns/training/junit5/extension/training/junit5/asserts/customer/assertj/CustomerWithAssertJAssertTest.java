package de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.assertj;

import de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerWithAssertJAssertTest {

    @Test
    public void customerWithMatcher() {
        Customer anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));

        CustomerAssert.assertThat(anyCustomer)
                .hasAge(53)
                .hasFirstName("Bernd")
                .hasLastName("Hegmanns");
    }

    @Test
    public void facadeAssertions() {
        Customer anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));

        AllAssertions.assertThat(anyCustomer).hasAge(53).hasFirstName("Bernd").hasLastName("Hegmanns");



        AllAssertions.assertThat("hello").hasSize(5);
    }
}
