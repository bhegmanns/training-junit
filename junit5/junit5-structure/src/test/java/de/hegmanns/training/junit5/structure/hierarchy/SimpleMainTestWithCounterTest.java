package de.hegmanns.training.junit5.structure.hierarchy;

import de.hegmanns.training.junit5.structure.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleMainTestWithCounterTest {

    public Counter counter;
    public static final int INITIAL_VALUE = 1;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("SimpleMainTestWithCounterTest.beforeAll");
    }

    @BeforeAll
    public static void otherBeforeAll() {
        System.out.println("SimpleMainTestWithCounterTest.otherBeforeAll");
    }
    @BeforeEach
    public void beforeAnyTest() {
        counter = new Counter(INITIAL_VALUE);
    }

    @Test
    public void buildingCounterWorks() {
        Assertions.assertEquals(INITIAL_VALUE, counter.getValue());
    }
}
