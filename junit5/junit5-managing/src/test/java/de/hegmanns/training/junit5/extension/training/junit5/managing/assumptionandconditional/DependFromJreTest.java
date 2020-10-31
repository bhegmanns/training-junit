package de.hegmanns.training.junit5.extension.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class DependFromJreTest {

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void proceedByJre8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    public void proceedByJre11() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    public void proceedBy11Or8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    public void disabledBy11Or8() {

    }
}
