package de.hegmanns.training.junit5.extension.junit5.gradle.managing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class ExampleTest {

    @Test
    @Tag("wrong")
    public void onlyOneSimpleTest() {

        Assertions.assertTrue(false);
    }

    @Test
    public void secondSimpleTest() {
        Assertions.assertTrue(true);
    }
}
