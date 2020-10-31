package de.hegmanns.training.junit5.extension.training.junit5.structure.hierarchy;

import org.junit.jupiter.api.*;

public class MainTest {

    public MainTest() {

        System.out.println("call MainTest-constructor");
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println(" call MainTest-beforeAllTests");
    }

    @BeforeAll
    public static void beforeAllMainTestTests() {
        System.out.println("call beforeAllMainTestTests");
    }

    @BeforeEach
    public void beforeAnyTest() {
        System.out.println("  call MainTest-beforeAnyTest");
    }

    @BeforeEach
    public void beforeAnyMainTest() {
        System.out.println(" call beforeAnyMainTest");
    }

    @Test
    public void aMainTestCase() {
        System.out.println("   call MainTest-aMainTestCase");
    }

    @Test
    public void otherMainTestCase() {
        System.out.println("   call MainTest-otherMainTestCase");
    }

    @AfterEach
    public void afterAnyTest() {
        System.out.println("  call MainTest-afterAnyTest");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println(" call MainTest-afterAllTests");
    }
}
