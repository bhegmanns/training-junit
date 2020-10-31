package de.hegmanns.training.junit5.extension.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

}