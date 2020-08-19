package de.hegmanns.training.junit5.tag.tagging;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SubclassOfTaggedTest extends TaggedTest{
    
    @Test
    @Tag("tiny")
    public void testMe() {
        System.out.println("SubclassOfTaggedTest : testMe (tagged, high, tiny)");
    }

    @Test
    public void testMeeToo() {
        System.out.println("SubclassOfTaggedTest : testMeToo (tagged, high)");
    }
}
