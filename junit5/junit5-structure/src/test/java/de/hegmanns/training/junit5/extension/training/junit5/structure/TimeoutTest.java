package de.hegmanns.training.junit5.extension.training.junit5.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class TimeoutTest {
    @Test
    @Disabled("please enable for demonstration")
    public void timeoutWithWaiting() {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000);
            System.out.println("proceeded");
        });
    }

    @Test
    @Disabled("please enable for demonstration")
    public void timeoutWithoutWaiting() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000);
            System.out.println("proceeded");
                }
        );
    }
}
