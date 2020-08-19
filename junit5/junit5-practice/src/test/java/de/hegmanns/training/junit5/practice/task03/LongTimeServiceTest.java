package de.hegmanns.training.junit5.practice.task03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongTimeServiceTest {

    @Test
    public void proceedingTimeLowerThan1000() {
        String anyNumberString = "101";
        String otherAnyNumberString = "1000";

        LongTimeService longTimeService = new LongTimeService();
        long startTime = System.currentTimeMillis();
        int sum = longTimeService.add(anyNumberString, otherAnyNumberString);
        long finalTime = System.currentTimeMillis();
        long timeForService = finalTime - startTime;

        Assertions.assertTrue(timeForService <= 1000, "time for service : " + timeForService + "ms");
    }

    @Test
    public void proceedingTimeBetween600And1000() {
        String anyNumberString = "101";
        String otherAnyNumberString = "1000";

        LongTimeService longTimeService = new LongTimeService();
        long startTime = System.currentTimeMillis();
        int sum = longTimeService.add(anyNumberString, otherAnyNumberString);
        long finalTime = System.currentTimeMillis();
        long timeForService = finalTime - startTime;

        Assertions.assertTrue(timeForService >= 600 && timeForService <= 1000, "time for service : " + timeForService + "ms");
    }

    @Test
    public void nonParsableNumberString() {
        String anyParsableNumberString = "101";
        String anyUnparsableNumberString = "no number";

        LongTimeService longTimeService = new LongTimeService();
        try {
            longTimeService.add(anyParsableNumberString, anyUnparsableNumberString);
            Assertions.fail("NumberFormatException expected");
        } catch (NumberFormatException e) {
            // ok
        }
    }
}
