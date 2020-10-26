package de.hegmanns.training.junit5.practice.task15;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KennwortCheckerTest {

    @ParameterizedTest
    @CsvSource({"1", "11", ""})
    public void exceptionErwartet(String kennwortMussExceptionErzeugen) {

    }

    @ParameterizedTest
    @CsvSource({"1111111111"})
    public void keineExceptionErwartet(String kennwortMussErlaubtSein) {

    }

    @ParameterizedTest
    @MethodSource("erstelleTestCases")
    public void checkerFunktioniert(KennwortTestCase testCase) {

    }

    public Stream<KennwortTestCase> erstelleTestCases() {
        return Stream.of(new KennwortTestCase("111111111", false, "mehr als 8 Zeichen, aber ....")
//                , ...
        );
    }
    }
