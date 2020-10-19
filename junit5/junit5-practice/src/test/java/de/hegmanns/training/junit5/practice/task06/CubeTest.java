package de.hegmanns.training.junit5.practice.task06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

public class CubeTest {

//    @TestTemplate
//    @ExtendWith(CubeTestTemplateProvider.class)
    @TestWithCubeProvider
    public void checkForUnfairCube(CubeTestCase cubeTestCase) {
        int nextNumber = cubeTestCase.getCube().getNext();

        Assumptions.assumeTrue(cubeTestCase.getExpected().isPresent());
        Assertions.assertEquals(cubeTestCase.getExpected().get(), nextNumber);
    }

    @TestWithCubeProvider
    public void checkForAnything(String aString) {

    }
}