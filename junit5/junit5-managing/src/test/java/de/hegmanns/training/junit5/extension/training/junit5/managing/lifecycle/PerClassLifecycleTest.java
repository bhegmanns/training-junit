package de.hegmanns.training.junit5.extension.training.junit5.managing.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PerClassLifecycleTest {

    private int counter;

    public PerClassLifecycleTest() {
        System.out.println("call DefaultLifecycleTest-constructor");
    }

    @BeforeAll
    public void beforeAllNonStatic() {
        System.out.println("call beforeAll");
    }

    @AfterAll
    public void afterAllNonStatic() {
        System.out.println("call afterAll");
    }

    @Test
    public void oneTest() {
        System.out.println("instance = " + this.hashCode());
        System.out.println("counter = " + counter);
        counter++;
        System.out.println("counter after increment: " + counter);
    }

    @Test
    public void otherTest() {
        System.out.println("instance = " + this.hashCode());
        System.out.println("counter = " + counter);
        counter++;
        System.out.println("counter after increment: " + counter);
    }
}
