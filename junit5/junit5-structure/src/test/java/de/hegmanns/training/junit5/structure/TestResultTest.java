package de.hegmanns.training.junit5.structure;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestResultTest {

    @Test
    public void doNothingAndIsGreen() {

    }

    @Test
    public void doAnythingWithoutErrorAndIsGreen() {
        int i = 5;
        System.out.println("value = " + 5); // note: output in test is a silly idea
    }

    @Test
    @Disabled("disable me for demo")
    public void thisMethodThrowsAnExceptionAndFails() {
        throw new IllegalStateException("hating this");
    }

    @Test
    @Disabled("disable me for demo")
    public void thisMethodThrowsAnSpecialExceptionAndFails() {
        throw new AssertionError("hating this");
    }
}
