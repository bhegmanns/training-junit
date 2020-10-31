package de.hegmanns.training.junit5.extension.training.junit.special;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestFactoryTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE-ALL");
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("BEFORE");
    }

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
