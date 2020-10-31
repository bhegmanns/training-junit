package de.hegmanns.training.junit5.extension.training.junit5.tdd.example;

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

    /*
    > (Max_int) + 1 >>>> ?
    > (Max_int) >>> Max_int
    > (Min_int) >>> Min_int
    > (Max_long) >>> ?
    > "0" >>> 0
    > "10" >>> 10
    > "NaN" >>>
    > "1.1" >>>
    > "-10" >>> -10
     */
    @Test
    public void stringWith10ResultsIn10() {
        int result = StringCalculator.calculate("10");

        MatcherAssert.assertThat(result, Matchers.is(10));
    }

    @Test
    public void stringWithMaxIntResultsInMaxIn() {
        int result = StringCalculator.calculate("" + Integer.MAX_VALUE);

        MatcherAssert.assertThat(result, Matchers.is(0));
    }

//    @Test
//    public void stringWithNegativeNumberResultsInNegativeNumber() {
//        int result = StringCalculator.calculate("-10");
//
//        MatcherAssert.assertThat(result, Matchers.is(-10));
//    }

    @Test
    public void stringWithMaxLongResultsIn0() {
        int result = StringCalculator.calculate("" + Long.MAX_VALUE);
        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    @Disabled("Issue 123 for asking for business-b")
    public void stringWithDecimalResultsInUnknonn() {
        int result = StringCalculator.calculate("1.1");
        MatcherAssert.assertThat(result, Matchers.is(-10));
    }

    //
    @Test
    public void twoCommaSeparatedPositiveNumbersResultInSum() {
        int result = StringCalculator.calculate("10,100");
        MatcherAssert.assertThat(result, Matchers.is(110));
    }

    @Test
    public void twoCommaAndSpaceSeparatedPositiveNumbersResultInSum() {
        int result = StringCalculator.calculate("10, 100");
        MatcherAssert.assertThat(result, Matchers.is(110));
    }

//    @Test
//    public void twoCommaSeparatedPositiveAndNegativeEqualNumberResult0() {
//        int result = StringCalculator.calculate("-100,100");
//        MatcherAssert.assertThat(result, Matchers.is(0));
//    }

    @Test
    @Disabled("don't know")
    public void twoCommaSeparatedDecimalsResult_ask() {
        int result = StringCalculator.calculate("1.00,10,0"); // mal ".", mal "," als Dezimaltrenner
//        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    public void twoCommaSeparatedNumbersWithSumGreaterThanMaxIntResult1() {
        int result = StringCalculator.calculate("1," + Integer.MAX_VALUE);
        MatcherAssert.assertThat(result, Matchers.is(1));
    }

    @Test
    public void twoLineSeparatedPositiveNumbersResultInSum() {
        int result = StringCalculator.calculate("10\r\n100");
        MatcherAssert.assertThat(result, Matchers.is(110));
    }

//    @Test
//    public void twoLineSeparatedPositiveAndNegativeEqualNumberResult0() {
//        int result = StringCalculator.calculate("-100\r\n100");
//        MatcherAssert.assertThat(result, Matchers.is(0));
//    }

    @Test
    public void threeNumbersSeparatedResultsInSum() {
        int result = StringCalculator.calculate("10\r\n20,30");
        MatcherAssert.assertThat(result, Matchers.is(60));
    }

    @Test
    public void negativeNumberThrowsException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {StringCalculator.calculate("-10");});
    }

    @Test
    public void withOneNegativeNumberThrowsException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {StringCalculator.calculate("10,-10");});
    }

    @Test
    public void greaterThan1000ResultsIn0() {
        int result = StringCalculator.calculate("1001");
        MatcherAssert.assertThat(result, Matchers.is(0));
    }

    @Test
    public void separatedNumbersOneGreaterThan1000ResultsInSumOfNumbersLowerThan1000() {
        int result = StringCalculator.calculate("10,1001");
        MatcherAssert.assertThat(result, Matchers.is(10));
    }

}
