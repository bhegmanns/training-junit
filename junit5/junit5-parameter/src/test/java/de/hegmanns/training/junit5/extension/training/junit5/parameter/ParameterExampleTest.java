package de.hegmanns.training.junit5.extension.training.junit5.parameter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterExampleTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void simpleTestWithParameter(int value) {
        System.out.println("Value: " + value);
    }

    @DisplayName("run with parameter demo")
    @ParameterizedTest(name = "{displayName}: {index}: {argumentsWithNames} oder {0}")
//    @Test ==> NOTE: NO @Test-Annotation
    @CsvSource({"hello, 5", "java, 4", "world, 5"})
    public void runWithParameter(String value, int count) {
        Assertions.assertEquals(count, value.length(), "length of string");
    }

    @DisplayName("run with parameter demo without names")
    @ParameterizedTest(name = "{displayName}: {index}: {arguments} oder {0}")
//    @Test ==> NOTE: NO @Test-Annotation
    @CsvSource({"hello, 5", "java, 4", "world, 5"})
    public void runWithParameterDisplayWithoutTypes(String value, int count) {
        Assertions.assertEquals(count, value.length(), "length of string");
    }


}
