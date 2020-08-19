package de.hegmanns.training.junit5.structure.lifecyclemethods;

import org.junit.jupiter.api.*;

public class WithLifecycleMethodsTest {

    public WithLifecycleMethodsTest() {
        System.out.println("call WithLifecycleMethodsTest-constructor");
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println(" call beforeAllTests");
    }

    @BeforeEach
    public void beforeAnyTest() {
        System.out.println("  call beforeAnyTest");
    }

    @Test
    public void aTestCase() {
        System.out.println("   call aTestCase");
    }

    @Test
    public void otherTestCase() {
        System.out.println("   call otherTestCase");
    }

    @AfterEach
    public void afterAnyTest() {
        System.out.println("  call afterAnyTest");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println(" call afterAllTests");
    }
}
