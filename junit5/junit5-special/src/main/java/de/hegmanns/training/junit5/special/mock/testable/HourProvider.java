package de.hegmanns.training.junit5.special.mock.testable;

import java.time.LocalTime;

public class HourProvider {

    public int getCurrentHour() {
        return LocalTime.now().getHour();
    }
}
