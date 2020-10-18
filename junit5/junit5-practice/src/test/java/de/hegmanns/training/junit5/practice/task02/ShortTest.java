package de.hegmanns.training.junit5.practice.task02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Place here your tests for {@link ShortTermCalculator#getShortTerm(String)}.
 */
public class ShortTest {

    @Test
    public void willThrowIfNull() {

        try {
            ShortTermCalculator.getShortTerm(null);
        } catch (NullPointerException nullPointerException) {
            Assertions.assertEquals("input is null", nullPointerException.getMessage());
        }
    }
}
