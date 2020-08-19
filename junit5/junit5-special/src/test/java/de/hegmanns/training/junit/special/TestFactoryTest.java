package de.hegmanns.training.junit.special;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

public class TestFactoryTest {

    @TestFactory
    public List<DynamicTest> justCreatedTests() {

        return Arrays.asList(
                DynamicTest.dynamicTest("...", () -> Assertions.assertEquals(1, 1)),
                DynamicTest.dynamicTest("....", () -> Assertions.assertNotEquals(1, 2))
        );
    }
}
