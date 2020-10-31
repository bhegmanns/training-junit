package de.hegmanns.training.junit5.extension.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisableMeTest {

    @Test
    @Disabled("bla bla bla")
    public void aDisabledTest() {

    }

    @Test
    public void notDisabled() {

    }
}
