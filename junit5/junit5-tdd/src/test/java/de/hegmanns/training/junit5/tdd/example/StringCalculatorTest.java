package de.hegmanns.training.junit5.tdd.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    public void nullAsInputResultsIn0() {
        int result = StringCalculator.calculate(null);

        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    public void emptyStringResultsIn0() {
        int result = StringCalculator.calculate("");

        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    public void stringWith10ResultsIn10() {
        int result = StringCalculator.calculate("10");

        MatcherAssert.assertThat(result, Matchers.is(10));
    }

    @Test
    public void stringWithMaxIntResultsInZero() {
        int result = StringCalculator.calculate("" + Integer.MAX_VALUE);

        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    public void stringWithNeg10ResultsInNeg10() {

        Assertions.assertThrows(RuntimeException.class, () -> {StringCalculator.calculate("-10");}) ;

    }

    @Test
    @Disabled("need to specify")
    public void stringWithOneUpperIntMaxResultsInAnywhat() {
        int result = StringCalculator.calculate("" + (Integer.MAX_VALUE + 1));

        MatcherAssert.assertThat(result, Matchers.is(-10));
    }

    @Test
    public void twoCommaSeparatedNumbersResultsInSum() {
        int result = StringCalculator.calculate("200,42");

        MatcherAssert.assertThat(result, Matchers.is(242));
    }

    @Test
    public void zeroAndNumberResultsInNumber() {
        int result = StringCalculator.calculate("0,100");

        MatcherAssert.assertThat(result, Matchers.is(100));
    }

//    @Test
//    public void negativeAndPositiveNumberResultsInZero() {
//        int result = StringCalculator.calculate("-100,100");
//
//        MatcherAssert.assertThat(result, Matchers.is(0));
//    }

    @Test
    public void sumOfNumbersGreaterThanMaxIntResultsInZero() {
        int result = StringCalculator.calculate("1," + Integer.MAX_VALUE);

        MatcherAssert.assertThat(result, Matchers.is(1));
    }

    @Test
    public void twoLineSeparatedNumbersResultsSum() {
        int result = StringCalculator.calculate("10\r\n20");

        MatcherAssert.assertThat(result, Matchers.is(30));
    }

    @Test
    public void zeroAndNumberInSeparatedLinesResultsInNumber() {
        int result = StringCalculator.calculate("0\r\n20");

        MatcherAssert.assertThat(result, Matchers.is(20));
    }

    @Test
    public void threeNumbersSeparatedResultsInSum() {
        int result = StringCalculator.calculate("10\r\n20,30");

        MatcherAssert.assertThat(result, Matchers.is(60));
    }

    @Test
    public void oneNegativeNumberResultsInException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.calculate("-10\r\n20,30");
        });
    }

    @Test
    public void twoNumbersOneGreaterThan1000ResultsInNumber() {
        int result = StringCalculator.calculate("10,1001");

        MatcherAssert.assertThat(result, Matchers.is(10));
    }
}
