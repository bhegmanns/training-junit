package de.hegmanns.training.junit5.practice.task02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Place here your tests for {@link ShortTermCalculator#getShortTerm(String)}.
 *
 * null wird problem
 * "" wird ""
 * "a" wird a
 * "ab" wird ab
 * "abc" wird abc
 * "aaaaaaaaa" wird aaaaaaaaa
 * "aaaaaaaaaa" wird aaaaaaaaa
 * "aaaaaaaaaaa" wird a9a
 * "abbbbbbbbbbbbbbbbbbbba" wird a20a
 */
public class ShortTest {

    @Test
    public void willThrowIfNull() {

        try {
            ShortTermCalculator.getShortTerm(null);
        } catch (NullPointerException nullPointerException) {
            Assertions.assertEquals("input is null", nullPointerException.getMessage());
        }
    }


    @Test
    public void willThrowIfNullWithJupiter() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () -> {
            ShortTermCalculator.getShortTerm(null);
        });

        Assertions.assertEquals("input is null", nullPointerException.getMessage());
    }

    @Test
    public void emptyTerm() {
        String emptyString = "";

        String shortTerm = ShortTermCalculator.getShortTerm(emptyString);

        Assertions.assertEquals(emptyString, shortTerm);
    }

    @Test
    public void size1NotShortTerm() {
        String shortTerm = ShortTermCalculator.getShortTerm("a");

        Assertions.assertEquals("a", shortTerm);
    }

    @Test
    public void bigString() {
        String anyBigString = "abbbbbbbbbbbbbbbbbbbba";
        String expectedShortTerm = "a20a";

        String givenShortTerm = ShortTermCalculator.getShortTerm(anyBigString);

        Assertions.assertEquals(expectedShortTerm, givenShortTerm);
    }
}
