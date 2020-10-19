package de.hegmanns.training.junit5.practice.task01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Checks for {@link CalculatorForDivide#isDividableIntoEvenParts(int)}.
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

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(8);

        // assert
        Assertions.assertEquals(true, isEvenDividable);
    }

    @Test
    public void amountOfNegative1IsEvenDividable() {
        // arrange

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(-1);

        // assert
        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amountOfMaxIntIsEvenDividable() {
        // arrange

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(Integer.MAX_VALUE);

        // assert
        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amountOfMaxIntSub1IsEvenDividable() {
        // arrange

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(Integer.MAX_VALUE-1);

        // assert
        Assertions.assertEquals(true, isEvenDividable);
    }

    @Test
    public void amountOf1IsEvenDividable() {
        // arrange

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(1);

        // assert
        Assertions.assertEquals(false, isEvenDividable);
    }

    @Test
    public void amountOf2IsOddDividable() {
        // arrange
        boolean expectedDividable = false;
        int countOfElements = 2;

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(countOfElements);

        // assert
        Assertions.assertEquals(expectedDividable, isEvenDividable);
    }

    @Test
    public void amountOf10IsEvenDividable() {
        // arrange

        // act
        boolean isEvenDividable = CalculatorForDivide.isDividableIntoEvenParts(10);

        // assert
        Assertions.assertEquals(true, isEvenDividable);
    }
}
