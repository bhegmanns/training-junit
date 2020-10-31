package de.hegmanns.training.junit5.extension.training.junit5.breakpuzzles.break004;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JokeWithCastTest {

    @Test
    @Disabled
    public void castOfACast() {
        Assertions.assertEquals(-1, (int)(char)(byte)-1);
    }
}
