package de.hegmanns.training.junit5.practice.task10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public interface CommonTestInterface<T extends Number> {

    T getLowerValue();
    T getHigherValue();

    @Test
    default void checkSortable(){
        Assertions.assertTrue(getLowerValue().doubleValue() < getHigherValue().doubleValue());
    }
}
