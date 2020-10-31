package de.hegmanns.training.junit5.extension.training.junit5.managing.executionorder;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class ExecutionOrderAlphanumericTest {

    private static int value = 0;

    @Test
    public void alpha() {
        value++;
        Assertions.assertEquals(1, value);
    }

    @Test
//    @DisplayName("beta")
    public void gamma() {
        value++;
        Assertions.assertEquals(3, value);
    }

    @Test
    public void delta() {
        value++;
        Assertions.assertEquals(2, value);
    }
}
