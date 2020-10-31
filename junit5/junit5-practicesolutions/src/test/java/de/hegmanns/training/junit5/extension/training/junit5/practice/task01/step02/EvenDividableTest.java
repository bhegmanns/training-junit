package de.hegmanns.training.junit5.extension.training.junit5.practice.task01.step02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.task01.CalculatorForDivide;

/**
 * Checks for {@link practice.task01.CalculatorForDivide#isDividableIntoEventParts(int)}.
 *
 * <p>
 *     Possible inputs for test:<br/>
 *     <ul>
 *         <li>8 must result in <i>true</i></li>
 *         <li>0 wird <i>false</i></li>
 *         <li>-1 wird <i>false</i></li>
 *         <li>1 wird <i>false</i></li>
 *         <li>2 wird <i>false</i></li>
 *         <li>Integer.MAX (2147483647) wird <i>false</i></li>
 *         <li>Integer.MAX-1 (2147483646) wird <i>true</i></li>
 *         <li>-Integer.MAX wird <i>false</i></li>
 *     </ul>
 * </p>
 */
public class EvenDividableTest {

    @Test
    public void amountOf8IsEvenDividable() {
        // arrange
        boolean expectedDividable = true;
        int countOfElements = 8;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOfNegative1IsEvenDividable() {
        // arrange
        boolean expectedDividable = false;
        int countOfElements = -1;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOfMaxIntIsEvenDividable() {
        // arrange
        boolean expectedDividable = false;
        int countOfElements = Integer.MAX_VALUE;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOfMaxIntSub1IsEvenDividable() {
        // arrange
        boolean expectedDividable = true;
        int countOfElements = Integer.MAX_VALUE-1;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOf1IsEvenDividable() {
        // arrange#
        boolean expectedDividable = false;
        int countOfElements = 1;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOf2IsOddDividable() {
        // arrange
        boolean expectedDividable = false;
        int countOfElements = 2;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOf10IsEvenDividable() {
        // arrange
        boolean expectedDividable = true;
        int countOfElements = 10;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEventParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }
}
