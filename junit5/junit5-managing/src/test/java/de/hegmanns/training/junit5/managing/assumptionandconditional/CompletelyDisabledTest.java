package de.hegmanns.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("bla bla bla")
public class CompletelyDisabledTest {

    @Test
    public void thisTestDisabled() {
        System.out.println("thisTestDisabled");
    }

    @Test
    public void thisTestIsDisabledToo() {
        System.out.println("thisTestIsDisabledToo");
    }
}
