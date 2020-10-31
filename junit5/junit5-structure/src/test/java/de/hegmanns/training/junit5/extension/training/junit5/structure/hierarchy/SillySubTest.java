package de.hegmanns.training.junit5.extension.training.junit5.structure.hierarchy;

import org.junit.jupiter.api.Test;

public class SillySubTest extends SillyMain{

    @Test
    public void afterIncrement() {
        counter.increment();

        doAssertion(2);
    }
}
