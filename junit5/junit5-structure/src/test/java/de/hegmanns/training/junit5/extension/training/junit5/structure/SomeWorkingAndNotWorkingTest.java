package de.hegmanns.training.junit5.extension.training.junit5.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeWorkingAndNotWorkingTest {

    @Test
    private void privateTestMethodWillNotProceed() {
        Assertions.assertEquals(1, 2);
    }

    @Test
    public void publicTestMethodWillProceed() {
        // no content, so green test ;)
    }

//    @Test
//    public void simpleTestWithParamsResultInException(int aParam) {
//        // you get a ParameterResolutionException
//    }
}
