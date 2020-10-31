package de.hegmanns.training.junit5.extension.training.junit5.structure.testinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public interface CheckEquals<T, U> extends TestableInstance<T>, Accessor<T, U> {

    T createUnequalValue();

    @Test
    default void valueEqualsItself() {
        T anyOtherInstance = getInstance();
        T anyInstance = getInstance();
        Assertions.assertEquals(getValueFrom(anyInstance), getValueFrom(anyOtherInstance));
    }

    @Test
    default void valueUnequal() {
        T anyInstance = getInstance();
        T anyUnequalInstance = createUnequalValue();

        Assertions.assertNotEquals(getValueFrom(anyInstance), getValueFrom(anyUnequalInstance));
    }


}
