package de.hegmanns.training.junit5.extension.training.junit5.practice.task10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AggregationTest {

    @Test
    void checkForInteger(){
        Integer lowerValue = 1;
        Integer higherValue = 10;

        Assertions.assertTrue(lowerValue.doubleValue() < higherValue.doubleValue());
    }

    @Test
    void checkForFloat(){
        Float lowerValue = 1.1f;
        Float higherValue = 10f;

        Assertions.assertTrue(lowerValue.doubleValue() < higherValue.doubleValue());
    }

    @Test
    void checkForLong(){
        Long lowerValue = 1l;
        Long higherValue = 10l;

        Assertions.assertTrue(lowerValue.doubleValue() < higherValue.doubleValue());
    }
}
