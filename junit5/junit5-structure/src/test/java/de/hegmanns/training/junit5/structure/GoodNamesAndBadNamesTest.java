package de.hegmanns.training.junit5.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoodNamesAndBadNamesTest {

    @Test
    public void checkMath01() {
        Assertions.assertEquals(2, Math.abs(-2));
    }

    @Test
    public void checkMath02() {
        Assertions.assertEquals(100, Math.max(-1, 100));
    }

//    @Test
//    public void checkMath03() {
//        Assertions.assertEquals(100, Math.max(0, 99));
//    }
}
