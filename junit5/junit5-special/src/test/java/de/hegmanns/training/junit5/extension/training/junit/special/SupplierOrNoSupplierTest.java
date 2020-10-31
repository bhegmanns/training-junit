package de.hegmanns.training.junit5.extension.training.junit.special;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SupplierOrNoSupplierTest {

    @Test
    @Disabled("for prohibiting NPE")
    public void expectedNull() {
        Integer a = null;

        Assertions.assertNull(a, "value = " + a.intValue());
    }

    @Test
    public void expectedNNullWithSupplier() {
        Integer a = null;

        Assertions.assertNull(a, () -> "value = " + a.intValue());
    }
}
