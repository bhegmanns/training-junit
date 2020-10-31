package de.hegmanns.training.junit5.extension.exceptionhandler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ExceptionExtension.class)
public class WithExceptionTest {

    @Test
    public void throwingRuntimeException() {
        throw new RuntimeException("uuuh");
    }

    @Test
    public void throwingOtherRuntimeException() throws Exception{
        throw new RuntimeException("uh uh");
    }

    @Test
    @Disabled("enable for demonstration")
    public void throwingOtherException() throws Exception{
        throw new Exception("uh uh");
    }
}
