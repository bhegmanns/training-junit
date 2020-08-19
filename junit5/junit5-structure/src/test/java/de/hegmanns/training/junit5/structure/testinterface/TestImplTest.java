package de.hegmanns.training.junit5.structure.testinterface;

import org.junit.jupiter.api.Test;

public class TestImplTest implements TestInterface{

    @Test
    public void doTheTest() {
        System.out.println("doTheTest");
    }

    @Test
    public void doTheNextTest() {
        System.out.println("doTheNextTest");
    }
}
