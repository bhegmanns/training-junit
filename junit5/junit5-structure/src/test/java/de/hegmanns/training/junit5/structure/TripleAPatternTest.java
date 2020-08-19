package de.hegmanns.training.junit5.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripleAPatternTest {

    @Test
    public void coreMathMinWorks() {
        // arrange
        int anyFirst = 2;
        int anySecond = 10;

        // act
        int min = Math.min(anyFirst, anySecond);

        // assert
        Assertions.assertEquals(2, min);
    }
}
