package de.hegmanns.training.junit5.parameter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterAsValueSourceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void foo(int a) {
        System.out.println("a=" + a);
    }
}
