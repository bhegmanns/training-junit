package de.hegmanns.training.junit5.testfactory.introduction;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created tests by test-factory will be seen in test-runner like normal tests order parameterized test
 */
public class IntroductionTestFactoryTest {

    @BeforeAll // will proceeded ONE time
    public static void beforeAll() {
        System.out.println("BEFORE-ALL");
    }
    @BeforeEach // will proceeded ONE time for justCreatedTest and for otherCreatedTests (NOT for every by test-factory created DynamicTest)
    public void beforeEach() {
        System.out.println("BEFORE");
    }

    @TestFactory
    public Stream<DynamicTest> justCreatedTests() {

        return IntStream.range(1, 10)
                .mapToObj((i) -> DynamicTest.dynamicTest("test " + i, () -> {checkEquals(1,1);}));
    }

    @TestFactory
    public List<DynamicTest> otherCreatedTests() {
        return IntStream.range(1, 10).mapToObj((i) -> DynamicTest.dynamicTest("other test " + i, () -> {checkEquals(i, i);})).collect(Collectors.toList());
    }

    public void checkEquals(int a, int b) {
        Assertions.assertEquals(a, b);
    }
}
