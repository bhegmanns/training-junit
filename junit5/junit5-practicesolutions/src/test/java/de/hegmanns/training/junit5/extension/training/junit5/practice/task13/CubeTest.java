package de.hegmanns.training.junit5.extension.training.junit5.practice.task13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

public class CubeTest {

    @TestWithCubeProvider
    public void checkForUnfairCube(CubeTestCase cubeTestCase) {
        int nextNumber = cubeTestCase.getCube().getNext();

        Assumptions.assumeTrue(cubeTestCase.getExpected().isPresent());
        Assertions.assertEquals(cubeTestCase.getExpected().get(), nextNumber);
    }

//    @TestWithCubeProvider
//    public void checkForAnything(String aString) {
//
//    }
}
