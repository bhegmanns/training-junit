package de.hegmanns.training.junit5.extension.training.junit5.practice.task01.step01;

/**
 * Checks for {@link practice.task01.CalculatorForDivide#isDividableIntoEventParts(int)}.
 *
 * <p>
 *     Possible inputs for test:<br/>
 *     <ul>
 *         <li>8 must result in <i>true</i></li>
 *         <li> ammount = 2 + 6 (zwei gerade summanden) ergibt <i>true</i></li>
 *         <li> ammount = 5 + 6 (ein gerader und ein ungerader Summand) ergibt <i>false</i></li>
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
}
