package de.hegmanns.training.junit5.extension.training.junit5.practice.task10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public interface CommonTestInterface<T extends Number> {


    @Test
    default void checkSortable(){

    }
}
