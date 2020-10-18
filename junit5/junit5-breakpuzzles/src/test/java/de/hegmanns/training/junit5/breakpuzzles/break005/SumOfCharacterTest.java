package de.hegmanns.training.junit5.breakpuzzles.break005;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SumOfCharacterTest {

    @Test
    @Disabled
    public void sumOfCharacter() {
        Assertions.assertEquals("HA", "" + ('H' + 'a'));
    }
}
