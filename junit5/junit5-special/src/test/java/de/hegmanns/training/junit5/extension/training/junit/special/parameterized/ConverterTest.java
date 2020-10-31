package de.hegmanns.training.junit5.extension.training.junit.special.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

public class ConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"02.02.2020", "01.10.2020"})
    public void withTimeAndConverter(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate date) {
        Assertions.assertEquals(2020, date.getYear());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2020-01-01", "2020-10-01"})
    public void withTime(LocalDate date) {
        Assertions.assertEquals(2020, date.getYear());
    }
}
