package de.hegmanns.training.junit5.managing.executionorder;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class ExecutionOrderAlphanumericTest {

    @Test
    public void alpha() {

    }

    @Test
    public void gamma() {

    }

    @Test
    public void delta() {

    }
}
