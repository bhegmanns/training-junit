package de.hegmanns.training.junit5.extension.training.junit5.asserts.customer;

import java.time.LocalDate;

public class Customer {

    private String firstName;
    private String lastName;
    private LocalDate dayOfBirth;

    public Customer() {

    }

    public Customer(String firstName, String lastName, LocalDate dayOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
}
