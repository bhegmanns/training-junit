package de.hegmanns.training.junit5.extension.training.junit5.practice.task16;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import practice.task16.ExchangeRateProvider;
import practice.task16.ExchangeConverter;

import java.math.BigDecimal;

/**
 * Currency Converter:
 *
 * 	Input > Amount + currency (start currency)
 * 	Input > currency (target currency)
 *
 * 	Output > amount (in target currency)
 *
 * 	Ausgangsbasis: enter "correct" amount (muss also nicht mehr konvertiert werden)
 * 	                                    (ist bereits Qualitätsgesichert
 * 										(lässt auch nur positive icl. 0 Werte zu))
 * 				   Maximum:
 * 	10Mio			   Minimum: 0
 *
 * 				   enter currency: Currency
 *
 * possibile
 * Steps:
 *  (1) if start currency = target currency then start amount = target amount (without calculation)
 *  - if amount is exact 0 then target amount is 0
 *
 *  - amount a null
 *  - amount negative
 *
 *  - symbol(s) are null
 *  - symbol(s) != 3 char
 *
 *  - 1000EUR >>> 500USD ; 1000EUR >> 500USD  >>> signs is always positive
 *
 *  - max amounts?
 *    1Mio >>> 1000000 is possible
 *
 *  - calculation must fit
 *    1EUR >>> 1,19 USD (21.10.2020)
 */
public class ExchangeConverterTest {

    @Test
    public void equalStartAndTargetCurrencyResultIntoEqualAmount() {
        BigDecimal amount = BigDecimal.TEN;
        String equalCurrencySymbol = "EUR";

        ExchangeRateProvider provider = Mockito.mock(ExchangeRateProvider.class);
        currentRate100(provider);
        ExchangeConverter.provider = provider;

        BigDecimal gotAmount = ExchangeConverter.convert(amount, equalCurrencySymbol, equalCurrencySymbol);

        MatcherAssert.assertThat(gotAmount, Matchers.comparesEqualTo(amount));

        Mockito.verify(provider, Mockito.never()).getExchangeRateForEuro(Mockito.anyString());
    }

    @Test
    public void amountZeroResultsInAmountZero() {
        String anyStartCurrencySymbol = "EUR";
        String anyTargetCurrencySymbol = "USD";

        BigDecimal gotAmount = ExchangeConverter.convert(BigDecimal.ZERO, anyStartCurrencySymbol, anyTargetCurrencySymbol);

        MatcherAssert.assertThat(gotAmount, Matchers.comparesEqualTo(BigDecimal.ZERO));
    }

    @Test
    public void amountNullResultsInException() {
        Assertions.assertThrows(NullPointerException.class, () -> ExchangeConverter.convert(null, "EUR", "EUR"));
    }

    @Test
    public void negativeAmountResultsInException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EUR", "EUR"));
    }

    @Test
    public void startCurrencyNullResultsInException() {
        Assertions.assertThrows(NullPointerException.class, () -> ExchangeConverter.convert(BigDecimal.ONE, null, "EUR"));
    }

    @Test
    public void targetCurrencyNullResultsInException() {
        Assertions.assertThrows(NullPointerException.class, () -> ExchangeConverter.convert(BigDecimal.ONE, "EUR", null));
    }

    @Test
    public void startCurrencyLessThenThreeCharacterResultsInException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EU", "EUR"));
    }

    @Test
    public void targetCurrencyMoreThanThreeCharacterResultsInException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EUR", "EURO"));
    }

    @Test
    public void startCurrencyLessThenThresseAndTargetCurrencyMoreThanThreeCharacterResultsInException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EU", "EURO"));
    }

    @Test
    public void currencyConverterWorkCurrectForUSD() {
        BigDecimal amount = BigDecimal.ONE;
        String startCurrencySymbol = "EUR";
        String targetCurrencySymbol = "USD";
        BigDecimal expectedAmount = new BigDecimal("100");

//      (1)  Assumptions für 21.10.2020 :(

//      (2) connect to DB und fetch des current rate und calculate: 1 * rate
//        :(,

//      (3) connection to DB, and insert/update für USD >> 10
//            then without calculation expected result = 10

//      (4) use mock to enforce expected behave

        ExchangeRateProvider provider = Mockito.mock(ExchangeRateProvider.class);
        currentRate100(provider);

        ExchangeConverter.provider = provider;

        BigDecimal gotAmount = ExchangeConverter.convert(amount, startCurrencySymbol, targetCurrencySymbol);
        MatcherAssert.assertThat(gotAmount, Matchers.comparesEqualTo(expectedAmount));

        Mockito.verify(provider, Mockito.times(1)).getExchangeRateForEuro("USD");
    }

    private void currentRate100(ExchangeRateProvider provider) {
        Mockito.when(provider.getExchangeRateForEuro("USD")).thenReturn(new BigDecimal("100"));
    }

}
