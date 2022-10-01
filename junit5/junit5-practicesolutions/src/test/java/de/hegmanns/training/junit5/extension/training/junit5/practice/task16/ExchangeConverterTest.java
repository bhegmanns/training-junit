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
 * Währungsrechner:
 *
 * 	Input > Betrag + Währung (Ausgangswährung)
 * 	Input > Währung (Zielwährung)
 *
 * 	Output > Betrag (in Zielwährung)
 *
 * 	Ausgangsbasis: Eingabe "echte" Zahl (muss also nicht mehr konvertiert werden)
 * 	                                    (ist bereits Qualitätsgesichert
 * 										(lässt auch nur positive icl. 0 Werte zu))
 * 				   Maximum:
 * 	10Mio			   Minimum: 0
 *
 * 				   Eingabe Währung: Currency
 *
 * mögliche
 * Steps:
 *  (1) Wenn Ausgangswährung = Zielwährung dann Eingangsbetrag = Umrechnungsbetrag
 *  - Wenn Betrag exakt 0 dann Ausgangsbetrag exakt 0
 *
 *  - Betrag als null
 *  - Betrag negativ
 *
 *  - Symbol(e) sind null
 *  - Symbol(e) != 3 Stellen
 *
 *  - 1000EUR >>> 500USD ; 1000EUR >> 500USD  >>> Vorzeichen ist immer positiv
 *
 *  - Höchstbeträge?
 *    1Mio >>> 1000000 ist möglich
 *
 *  - Umrechnung muss passen
 *    1EUR >>> 1,19 USD (21.10.2020)
 */
public class ExchangeConverterTest {

    @Test
    public void gleicheZielwaehrungUndAusgangswaehrungErgibtGleichenBetrag() {
        BigDecimal betrag = BigDecimal.TEN;
        String gleicheWaehrungssymbol = "EUR";

        ExchangeRateProvider provider = Mockito.mock(ExchangeRateProvider.class);
        aktuellerKurs100(provider);
        ExchangeConverter.provider = provider;

        BigDecimal umgerechneterBetrag = ExchangeConverter.convert(betrag, gleicheWaehrungssymbol, gleicheWaehrungssymbol);

        MatcherAssert.assertThat(umgerechneterBetrag, Matchers.comparesEqualTo(betrag));

        Mockito.verify(provider, Mockito.never()).getExchangeRateForEuro(Mockito.anyString());
    }

    @Test
    public void betrag0FuehrtZuBetrag0() {
        String ausgangswaehrungsSymbol = "EUR";
        String zielwaehrungsSymbol = "USD";

        BigDecimal umgerechneterBetrag = ExchangeConverter.convert(BigDecimal.ZERO, ausgangswaehrungsSymbol, zielwaehrungsSymbol);

        MatcherAssert.assertThat(umgerechneterBetrag, Matchers.comparesEqualTo(BigDecimal.ZERO));
    }

    @Test
    public void betragIstNullErzeugtException() {
        Assertions.assertThrows(NullPointerException.class, () -> ExchangeConverter.convert(null, "EUR", "EUR"));
    }

    @Test
    public void negaBetragErzeugtException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EUR", "EUR"));
    }

    @Test
    public void eingangswaehrungIstNullErzeugtException() {
        Assertions.assertThrows(NullPointerException.class, () -> ExchangeConverter.convert(BigDecimal.ONE, null, "EUR"));
    }

    @Test
    public void ausgangswaehrungIstNullErzeugtException() {
        Assertions.assertThrows(NullPointerException.class, () -> ExchangeConverter.convert(BigDecimal.ONE, "EUR", null));
    }

    @Test
    public void waherungssystemKleiner3StellenErzeugtException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EU", "EUR"));
    }

    @Test
    public void waherungssystemGroesser3StellenErzeugtException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EUR", "EURO"));
    }

    @Test
    public void waehrungssymboleUngleich3StellenErzeugtException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExchangeConverter.convert(BigDecimal.ONE.negate(), "EU", "EURO"));
    }

    @Test
    public void waehrungsrechnerRechnetEinEurRichtigInDollar() {
        BigDecimal betrag = BigDecimal.ONE;
        String ausgangswaehrung = "EUR";
        String zielwaehrung = "USD";
        BigDecimal erwarteterBetrag = new BigDecimal("100");

//      (1)  Assumptions für 21.10.2020 :(

//      (2) Verbindung zur DB und Holen des aktuelles Kurses und Berechnen: 1 * Kurs
//        :(, weil zu viel Logik, die im Zweifel im Waehrungsrechnet genau so verwendet wird

//      (3) Verbindung zur DB, und insert/update für USD >> 10
//            Dann ohne berechnung erwartetes Ergebnis = 10
//        :|

//      (4) Mock verwenden um definiertes Verhalten zu erzwingen

        ExchangeRateProvider provider = Mockito.mock(ExchangeRateProvider.class);
        aktuellerKurs100(provider);

//        TestMOckFactory.getProviderFuerKurs(100);
        ExchangeConverter.provider = provider;

//        Waehrungsrechner rechner = new Waehrungsrechner();
//        rechner = Mockito.spy(rechner);
//        rechner.umrechnen();
//        Mockito.verify(rechner).umrechnen();

        BigDecimal umgerechneterWert = ExchangeConverter.convert(betrag, ausgangswaehrung, zielwaehrung);
        MatcherAssert.assertThat(umgerechneterWert, Matchers.comparesEqualTo(erwarteterBetrag));

        Mockito.verify(provider, Mockito.times(1)).getExchangeRateForEuro("USD");
    }

    private void aktuellerKurs100(ExchangeRateProvider provider) {
        Mockito.when(provider.getExchangeRateForEuro("USD")).thenReturn(new BigDecimal("100"));
    }

//    @Test
//    public void nichtValideWaehrungFuehrtZurException() {
//        BigDecimal anybetrag = BigDecimal.TEN;
//        String gleicheWaehrungssymbol = "ANY";
//
//        Waehrungstechner.umrechnen(anybetrag, gleicheWaehrungssymbol, gleicheWaehrungssymbol);
//
//    }
}
