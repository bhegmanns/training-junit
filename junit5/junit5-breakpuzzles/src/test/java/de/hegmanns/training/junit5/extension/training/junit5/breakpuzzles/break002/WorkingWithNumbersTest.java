package de.hegmanns.training.junit5.extension.training.junit5.breakpuzzles.break002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class WorkingWithNumbersTest {

    @Test
    @Disabled
    public void trustInNumbers() {
        long millisPerDay = 24 * 60 * 60 * 1000;
        long microsPerDay = 24 * 60 * 60 * 1000 * 1000;

        Assertions.assertEquals(1000, microsPerDay / millisPerDay);
    }
}
