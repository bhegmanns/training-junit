package de.hegmanns.training.junit5.extension.training.junit5.practice.task07.step02;

import org.junit.jupiter.api.Test;


public class LongOrNotLongTest {



    @Test
    @NoLongTest
    public void itsALongTest() {

    }

    @Test
    @NoLongTest
    public void itsAShortTest() {

    }
}
