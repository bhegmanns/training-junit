package de.hegmanns.training.junit5.asserts.customer.assertj;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.assertj.core.api.Assertions;

public class AllAssertions extends Assertions {

    public static CustomerAssert assertThat(Customer customer) {
        return new CustomerAssert(customer);
    }
}
