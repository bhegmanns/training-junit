package de.hegmanns.training.junit5.extension.training.junit5.structure.hierarchy;

import de.hegmanns.training.junit5.extension.training.junit5.structure.Counter;
import org.junit.jupiter.api.Assertions;

public class SillyMain {

    public Counter counter = new Counter(1);

    public void doAssertion(int expectedValue) {
        Assertions.assertEquals(expectedValue, counter.getValue());
    }
}
