package de.hegmanns.training.junit5.extension.training.junit5.managing.tagging;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SubclassOfTaggedTest extends TaggedTest{

    @Test
    public void testMe() {
        System.out.println("SubclassOfTaggedTest: ");
    }
}
