package de.hegmanns.training.junit.special;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestFactoryTest {

    @TestFactory
    public Stream<DynamicTest> justCreatedTests() {

        return IntStream.range(1, 100)
                //. map(...)
                .mapToObj((i) -> DynamicTest.dynamicTest("...", () -> {checkEquals(1,1);}));

//        return Arrays.asList(
//                DynamicTest.dynamicTest("...", () -> checkEquals(1, 1)),
//                DynamicTest.dynamicTest("....", () -> checkEquals(1,2))
//        );
    }

    public void checkEquals(int a, int b) {
        Assertions.assertEquals(a, b);
    }
}
