package de.hegmanns.training.junit5.practice.task01;

/**
 * @author Bernd Hegmanns
 * @version 0.9
 */
public class CalculatorForDivide {

    /**
     * Indicates is the given <i>amount</i> can be split into (not needed equal) two parts with even amount.
     * <p>
     *     <b>Example:</b><br>
     *     Amount 8 can be split into 4 and 4. 4 is an even number, so splitting 8 into even amount is possible.<br>
     *     Amount 5 can be split into 1 and 4, 2 and 3. Both variants don't have only even amount, so itsn't possible.
     * </p>
     * @param amount the amount to be split
     * @return <i>true</i>, if the amount can be split into even parts, else <i>false</i>
     */
    public static boolean isDividableIntoEventParts(int amount) {
        return amount % 2 == 0;
    }
}
