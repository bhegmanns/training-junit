package de.hegmanns.training.junit5.version57.executionorder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ExecutionOrderDisplayNameTest {

    @Test
    @DisplayName("beta")
    public void foo1() {

    }

    @Test
    @DisplayName("alpha")
    public void foo2() {

    }

    @Test
    @DisplayName("gamma")
    public void foo3() {

    }
}
