package de.hegmanns.training.junit5.structure.hierarchy;

import org.junit.jupiter.api.*;

public class SubTest extends MainTest{

    public SubTest() {

        System.out.println("call SubTest-constructor");
    }

    @BeforeAll
    public static void beforeAllTests() {

        System.out.println(" call SubTest-beforeAllTests");
    }

    @BeforeEach
    public void beforeAnyTest() {
        System.out.println("  call SubTest-beforeAnyTest");
    }

    @Test
    public void aSubTestCase() {
        System.out.println("   call SubTest-aSubTestCase");
    }

    @Test
    public void otherSubTestCase() {
        System.out.println("   call SubTest-otherSubTestCase");
    }

    @AfterEach
    public void afterAnyTest() {
        System.out.println("  call SubTest-afterAnyTest");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println(" call SubTest-afterAllTests");
    }
}
