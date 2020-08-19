package de.hegmanns;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpyTestInstancePostProcessor.class)
public class SimpleTest {

    @Test
    public void testTheBest(TestReporter testReporter) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testReporter.publishEntry("that's it");
    }

    @Test
    public void testTheOther(TestReporter testReporter) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testReporter.publishEntry("that's it");
    }
}
