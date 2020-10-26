package de.hegmanns.training.junit5.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class TimeoutTest {
    @Test
    public void timeoutWithWaiting() {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000);
            System.out.println("proceeded");
        });
    }

    @Test
    public void timeoutWithoutWaiting() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000);
            System.out.println("proceeded");
                }
        );
    }
}
