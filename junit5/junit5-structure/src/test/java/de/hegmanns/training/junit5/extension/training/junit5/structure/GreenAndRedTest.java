package de.hegmanns.training.junit5.extension.training.junit5.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class GreenAndRedTest {

    private boolean neverFail = true;

    public void thisMethodWillNotProceedAndDisplayedInJUnit() {
        // missing annotation
    }

    @Test
    public void thisMethodWillProceedAndDisplayedAsGreen() {
        // Junit will not check the content
        // Junit only checks running without fail and error
    }

    @Test
    @Disabled("please enable for demonstration")
    public void thisMethodWillProceedAndDisplayedAsFailureByAssertionError() {
        throw new AssertionError("this is an example failed test-method");
    }

    @Test
    @Disabled("please enable for demonstration")
    public void thisMethodWillProceedAndDisplayedAsFailureByAssertion() {
        Assertions.assertEquals(1, 2, "this is an example failed test-method");
    }

    @Test
    @Disabled("please enable for demonstration")
    public void thisMethodWillProceedAndDisplayedAsErrorByThrowingException() {
        throw new RuntimeException("a Runtime-Exception");
    }

    @Test
    public void methodWithThrowsWithoutThrowing() throws IOException {
        if (!neverFail) {
            throw new IOException("it happens");
        }
    }

    @Test
    @Disabled("please enable for demonstration")
    public void methodWithThrowsAndThrowingDisplayedAdError() throws IOException {
        throw new IOException("uuuuh");
    }
}
