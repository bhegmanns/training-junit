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
    public void betrag0FuehrtZuBetrag0() {
        String anyAusgangswaehrung = "EUR";
        String anyZielwaehrung = "USD";

        BigDecimal umgerechneterWert = ExchangeRateConverter.umrechnen(BigDecimal.ZERO, anyAusgangswaehrung,
                anyZielwaehrung);
        MatcherAssert.assertThat(umgerechneterWert, Matchers.comparesEqualTo(BigDecimal.ZERO));
    }

    //(2) Betrag egal, Eingangswährung==Ausgangswährung >>> Umrechnungsbetrag = Betrag (ggf. same)

}
