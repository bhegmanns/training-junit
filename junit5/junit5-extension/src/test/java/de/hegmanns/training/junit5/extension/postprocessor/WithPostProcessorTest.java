package de.hegmanns.training.junit5.extension.postprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpyTestInstancePostProcessor.class)
public class WithPostProcessorTest {

    @Test
    public void testTheBest(TestReporter testReporter) {
        testReporter.publishEntry("final");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testReporter.publishEntry("final");
        testReporter.publishEntry("name", "Bernd");
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
