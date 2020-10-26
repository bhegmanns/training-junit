package de.hegmanns.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDate;
import java.time.Period;

public class CustomerMatcher extends TypeSafeMatcher<Customer> {

    public static Matcher<Customer> hasAge(int expectedYears) {
        return new CustomerMatcher(expectedYears);
    }

    int expectedYears;
    public CustomerMatcher(int expectedYears) {
        this.expectedYears = expectedYears;
    }
    @Override
    protected boolean matchesSafely(Customer item) {
        LocalDate dayOfBirth = item.getBirthDay();
        LocalDate today = LocalDate.now();

        Period until = dayOfBirth.until(today);
        return until.getYears() == expectedYears;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("age of customer");
    }
}
