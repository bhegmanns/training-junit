package de.hegmanns.training.junit5.extension.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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
