package de.hegmanns.training.junit5.version57.executionorder;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * {@link MethodOrderer.Alphanumeric} is deprecated with version 5.7 and is substituted by {@link MethodOrderer.MethodName}
 * with same function.
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class ExecutionOrderMethodNameTest {

    @Test
    public void alpha() {

    }

    @Test
    public void gamma() {

    }

    @Test
    public void delta() {

    }

    @Test
    public void beta() {

    }
}
