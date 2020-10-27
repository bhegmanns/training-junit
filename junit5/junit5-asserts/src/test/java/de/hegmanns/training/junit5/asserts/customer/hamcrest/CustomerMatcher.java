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

    public static Matcher<Customer> hasFirstName(String expectedFirstName){return new CustomerMatcher(expectedFirstName);}

    Integer expectedYears;
    String expectedFirstName;
    public CustomerMatcher(int expectedYears) {
        this.expectedYears = expectedYears;
    }

    public CustomerMatcher(String expectedFirstName){this.expectedFirstName = expectedFirstName;}

    @Override
    protected boolean matchesSafely(Customer item) {
        if (expectedYears!=null) {
            LocalDate dayOfBirth = item.getBirthDay();
            LocalDate today = LocalDate.now();

            Period until = dayOfBirth.until(today);
            return until.getYears() == expectedYears;
        }
        if (expectedFirstName != null) {
            return item.getFirstName().toLowerCase().equals(expectedFirstName.toLowerCase());
        }

        return true;
    }

    @Override
    protected void describeMismatchSafely(Customer item, Description mismatchDescription) {
        super.describeMismatchSafely(item, mismatchDescription);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("age of customer");
    }
}
