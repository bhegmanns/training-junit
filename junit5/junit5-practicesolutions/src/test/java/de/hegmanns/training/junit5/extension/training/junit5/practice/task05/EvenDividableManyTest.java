package de.hegmanns.training.junit5.extension.training.junit5.practice.task05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import practice.task01.CalculatorForDivide;

public class EvenDividableManyTest {

    @ParameterizedTest
    @CsvSource({"0, false",
            "-1, false",
            "1, false",
            "2, false",
            "8, true",
            "222, true",
            "11, false",
            Integer.MAX_VALUE + ", false",
            (Integer.MAX_VALUE - 1) + ", true"})
    public void checkEvenDividable(int amount, boolean dividableExpected) {
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(dividableExpected, isEvenDividable);
    }

    @Test
    public void amountOf0IsNotEvenDividable() {
        int amount = 0;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amountOfNeg1IsNotEvenDividable() {
        int amount = -1;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amount1fNeg1IsNotEvenDividable() {
        int amount = 1;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amount2fNeg1IsNotEvenDividable() {
        int amount = 2;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amountOfMaxInIsNotEvenDividable() {
        int amount = Integer.MAX_VALUE;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amountOfOneBeforeMaxInIsNotEvenDividable() {
        int amount = Integer.MAX_VALUE-1;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(true, isEvenDividable);
    }

    @Test
    public void amountOf8IsEvenDividable() {
        int amount = 8;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(true, isEvenDividable);
    }

    @Test
    public void amountOf11IsNotEvenDividable() {
        int amount = 11;

        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(amount);

        Assertions.assertEquals(false, isEvenDividable);
    }
}
