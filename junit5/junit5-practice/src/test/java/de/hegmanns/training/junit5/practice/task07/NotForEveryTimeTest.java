package de.hegmanns.training.junit5.practice.task07;


import org.junit.jupiter.api.Test;

public class NotForEveryTimeTest {

    @Test
    @DisableOnTime
    public void thisTestShouldBeDisabledEveryTime() {
        System.out.println("NotForEveryTimeTest");
    }

    @Test
    @DisableOnTime(from = "09:30", until = "14:00")
    public void thisTestShouldBeDisabledFrom10To14() {
        System.out.println("should be disabled from 10 to 14");
    }

    @Test
    @DisableOnTime(from = "12:39", until = "12:45") // change it
    public void defineDisabledOrActivating_consultYourClock() {
        System.out.println("should be disabled from 12:39 to 12:45");
    }
}
