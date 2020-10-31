package de.hegmanns.training.junit5.repeated.introduction;

import org.junit.jupiter.api.*;

public class RepeatedWithLifecycleAnnotationTest {

    @BeforeAll // will be proceeded ONE time
    public static void beforeAll() {
        System.out.println("BEFORE-ALL");
    }

    @BeforeEach // will be proceeded before every repetition
    public void beforeAnyTest() {
        System.out.println("BEFORE");
    }

    @RepeatedTest(value = 5)
    public void methodWithRepetition(RepetitionInfo info) {
        System.out.println("test " + info.getCurrentRepetition());
    }

    @AfterEach // will be proceeded after every repetition
    public void afterAnyTest() {
        System.out.println("AFTER");
    }

    @AfterAll // will be proceeded one time
    public static void afterAll() {
        System.out.println("AFTER-ALL");
    }
}
