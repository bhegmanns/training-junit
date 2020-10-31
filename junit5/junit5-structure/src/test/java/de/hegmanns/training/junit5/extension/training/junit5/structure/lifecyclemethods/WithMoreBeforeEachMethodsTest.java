package de.hegmanns.training.junit5.extension.training.junit5.structure.lifecyclemethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WithMoreBeforeEachMethodsTest {

    @BeforeEach
    public void otherForEach() {
        System.out.println("call otherForEach");
    }

    @BeforeEach
    public void oneForEach() {
        System.out.println("call oneForEach");
    }



    @Test
    public void testCase() {

    }
}
