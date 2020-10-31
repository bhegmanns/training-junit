package de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.assertj;

import de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.Customer;

public class CustomerAssertions {

    public static CustomerAssert assertThat(Customer customer) {
        return new CustomerAssert(customer);
    }
}
