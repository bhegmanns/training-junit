package de.hegmanns.training.junit5.tag.tagging;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("tagged")
@Tag("high")
public class TaggedTest {

    @Test
    @Tag("simple")
    public void simpleTest() {
        System.out.println("TaggedTest : simpleTest (tagged, high, simple)");
    }

    @Test
    public void normalTest() {
        System.out.println("TaggedTest : simpleTest (tagged, high)");
    }
}
