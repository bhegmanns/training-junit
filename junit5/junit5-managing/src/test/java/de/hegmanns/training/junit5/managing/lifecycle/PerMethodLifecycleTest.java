package de.hegmanns.training.junit5.managing.lifecycle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PerMethodLifecycleTest {

    private int counter;

    public PerMethodLifecycleTest() {
        System.out.println("call DefaultLifecycleTest-constructor");
    }

//    @BeforeAll
//    public void beforeAllNonStaticWillRaiseJunitException() {
//
//    }

    @Test
    public void oneTest() {
        System.out.println("instance = " + this.hashCode());
        System.out.println("counter = " + counter);
        counter++;
        System.out.println("counter after increment: " + counter);
        Assertions.assertEquals(1, counter);
    }

    @Test
    public void otherTest() {
        System.out.println("instance = " + this.hashCode());
        System.out.println("counter = " + counter);
        counter++;
        System.out.println("counter after increment: " + counter);
        Assertions.assertEquals(1, counter);
    }
}
