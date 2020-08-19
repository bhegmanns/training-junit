package de.hegmanns.training.junit5.managing.tagging;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("tagged")
@Tag("high")
public class TaggedTest {

    @Test
    @Tag("simple")
    public void simpleTest() {

    }

    @Test
    public void normalTest() {

    }
}
