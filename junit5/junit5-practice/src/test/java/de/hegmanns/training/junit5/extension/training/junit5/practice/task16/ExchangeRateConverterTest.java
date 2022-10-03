package de.hegmanns.training.junit5.extension.training.junit5.practice.task16;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Währungsrechner:
 *

 */
public class ExchangeRateConverterTest {

    @Test
    public void amountZeroResultsInAmountZero() {
        String anyStartCurrency = "EUR";
        String anyTargetCurrency = "USD";

        BigDecimal umgerechneterWert = ExchangeRateConverter.convert(BigDecimal.ZERO, anyStartCurrency,
                anyTargetCurrency);
        MatcherAssert.assertThat(umgerechneterWert, Matchers.comparesEqualTo(BigDecimal.ZERO));
    }

    //(2) ... Betrag egal, Eingangswährung==Ausgangswährung >>> Umrechnungsbetrag = Betrag (ggf. same)

}
