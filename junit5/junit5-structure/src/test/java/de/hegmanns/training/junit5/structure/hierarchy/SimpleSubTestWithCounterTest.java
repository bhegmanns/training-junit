package de.hegmanns.training.junit5.structure.hierarchy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleSubTestWithCounterTest extends SimpleMainTestWithCounterTest{

    @BeforeAll
    public static void beforeAll() {
        System.out.println("SimpleSubTestWithCounterTest.beforeAll");
    }

    @Test
    public void resetWorks() {
        counter.increment();
        counter.increment();

        counter.reset();

        Assertions.assertEquals(INITIAL_VALUE, counter.getValue());
    }
}
