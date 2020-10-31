package de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.assertj;

import de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SimpleCustomerAssertJTest {

    @Test
    public void correctAge() {
        Customer anyCustomer = new Customer("Bernd", "Hegmanns", LocalDate.of(1967, 6, 19));

        Assertions.assertThat(anyCustomer).hasFieldOrProperty("lastName");
        Assertions.assertThat(anyCustomer).hasFieldOrPropertyWithValue("lastName", "Hegmanns");
    }
}
