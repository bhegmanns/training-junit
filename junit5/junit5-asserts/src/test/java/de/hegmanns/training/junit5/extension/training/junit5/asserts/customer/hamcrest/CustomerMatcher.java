package de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.hamcrest;

import de.hegmanns.training.junit5.extension.training.junit5.asserts.customer.Customer;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomerMatcher extends TypeSafeMatcher<Customer> {

    public static Matcher<Customer> hasAge(int expectedAge) {
        return new CustomerMatcher(expectedAge);
    }

    public static Matcher<Customer> hasFirstName(String expectedFirstName){return new CustomerMatcher(expectedFirstName);}

    Integer expectedAge;
    boolean checkAge;

    String expectedFirstName;
    boolean checkExpectedFirstName;
    public CustomerMatcher(int expectedYears) {
        this.checkAge = true;
        this.expectedAge = expectedYears;
    }

    public CustomerMatcher(String expectedFirstName){
        this.checkExpectedFirstName = true;
        this.expectedFirstName = expectedFirstName;}

    @Override
    protected boolean matchesSafely(Customer item) {
        if (checkAge) {
            LocalDate dayOfBirth = item.getBirthDay();
            LocalDate today = LocalDate.now();

            return getPeriodInYears(dayOfBirth, today) == expectedAge;
        }
        if (checkExpectedFirstName) {
            return item.getFirstName().toLowerCase().equals(expectedFirstName.toLowerCase());
        }

        return true;
    }

    private int getPeriodInYears(LocalDate startDate, LocalDate finalDate) {
        return startDate.until(finalDate).getYears();
    }

    @Override
    protected void describeMismatchSafely(Customer item, Description mismatchDescription) {
        if (checkAge) {
            mismatchDescription.appendText("day of birth is " + item.getBirthDay().format(DateTimeFormatter.ISO_DATE))
                    .appendText(", so todays age is " + getPeriodInYears(item.getBirthDay(), LocalDate.now()));
        }

        if (checkExpectedFirstName) {
            mismatchDescription.appendText("first name is '" + item.getFirstName() + "'");
        }

    }

    @Override
    public void describeTo(Description description) {
        ArrayList<String> checks = new ArrayList<>();
        if (checkAge) {
            checks.add("age should be " + expectedAge);
        }
        if (checkExpectedFirstName) {
            checks.add("firstName should be '" + expectedFirstName + "'");
        }
        description.appendText("customer: ").appendText(checks.stream().collect(Collectors.joining(",")));

    }
}
