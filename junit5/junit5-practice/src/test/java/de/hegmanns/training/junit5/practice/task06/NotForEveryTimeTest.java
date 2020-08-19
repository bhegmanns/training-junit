package de.hegmanns.training.junit5.practice.task06;


import org.junit.jupiter.api.Test;

public class NotForEveryTimeTest {

    @Test
//    @DisableOnTime
    public void thisTestShouldBeDisabledEveryTime() {
        System.out.println("NotForEveryTimeTest");
    }

    @Test
//    @DisableOnTime(from = "10:00", until = "14:00")
    public void thisTestShouldBeDisabledFrom10To14() {

    }

    @Test
//    @DisableOnTime(from = "12:39", until = "12:45") // change it
    public void defineDisabledOrActivating_consultYourClock() {

    }
}
