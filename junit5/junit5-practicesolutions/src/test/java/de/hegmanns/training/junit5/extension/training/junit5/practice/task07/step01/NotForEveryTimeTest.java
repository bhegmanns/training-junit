package de.hegmanns.training.junit5.extension.training.junit5.practice.task07.step01;

import de.hegmanns.training.junit5.extension.training.junit5.practice.task07.DisableOnTime;
import org.junit.jupiter.api.Test;

public class NotForEveryTimeTest {
    @Test
    @DisableOnTime
    public void thisTestShouldBeDisabledEveryTime() {
        System.out.println("NotForEveryTimeTest");
    }

    @Test
    @DisableOnTime(from = "10:00", until = "14:00")
    public void thisTestShouldBeDisabledFrom10To14() {

        System.out.println("should be disabled from 10 to 14");
    }

    @Test
    @DisableOnTime(from = "09:00", until = "09:10") // change it
    public void defineDisabledOrActivating_consultYourClock() {
        System.out.println("should be disabled from 12:39 to 12:45");
    }
}
