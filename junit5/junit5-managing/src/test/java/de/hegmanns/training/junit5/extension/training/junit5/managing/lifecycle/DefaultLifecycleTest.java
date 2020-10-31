package de.hegmanns.training.junit5.extension.training.junit5.managing.lifecycle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultLifecycleTest {

    private int counter;

    public DefaultLifecycleTest() {
        System.out.println("call DefaultLifecycleTest-constructor");
    }

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
