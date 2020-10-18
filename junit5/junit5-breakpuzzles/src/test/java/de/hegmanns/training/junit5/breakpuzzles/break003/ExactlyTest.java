package de.hegmanns.training.junit5.breakpuzzles.break003;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ExactlyTest {

    @Test
    @Disabled
    public void exactlyFloatingPoint() {
        double first = 2.00;
        double second = 1.10;

        double diff = first - second;

        Assertions.assertEquals(0.9, diff);
    }
}
