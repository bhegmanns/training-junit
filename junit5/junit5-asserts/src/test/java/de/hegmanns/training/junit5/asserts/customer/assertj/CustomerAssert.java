package de.hegmanns.training.junit5.asserts.customer.assertj;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.assertj.core.api.AbstractAssert;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {

    public CustomerAssert(Customer customer) {
        super(customer, CustomerAssert.class);
    }

    public static CustomerAssert assertThat(Customer customer) {
        return new CustomerAssert(customer);
    }

    public CustomerAssert hasFirstName(String firstName) {
        isNotNull();

        if (!Objects.equals(actual.getFirstName(), firstName)) {
            failWithMessage("", firstName, actual.getFirstName());
        }

        return this;
    }

    public CustomerAssert hasLastName(String lastName) {
        isNotNull();

        if (!Objects.equals(actual.getLastName(), lastName)) {
            failWithMessage("", lastName, actual.getFirstName());
        }

        return this;
    }

    public CustomerAssert hasAge(int years) {
        isNotNull();

        LocalDate dayOfBirth = actual.getDayOfBirth();
        LocalDate today = LocalDate.now();

        Period until = dayOfBirth.until(today);

        if (until.getYears() != years) {
            failWithMessage("", years, until.getYears());
        }

        return this;
    }
}
