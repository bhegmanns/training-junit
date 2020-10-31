package practice.task16;

import java.math.BigDecimal;

public class Waehrungsrechner {

    public static DevisenkursProvider provider;
    public static BigDecimal umrechnen(BigDecimal betrag, String ausgangwaehrung, String zielwaehrung) {
        checkInputs(betrag, ausgangwaehrung, zielwaehrung);
        if (rechnungOhneDevisenkursProviderMoeglich(betrag, ausgangwaehrung, zielwaehrung)) {
            if (betrag.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            } else {
                if (ausgangwaehrung.equals(zielwaehrung)) {
                    return betrag;
                }
            }
        }


        BigDecimal devisenkursFuerEuro = provider.getDevisenkursFuerEuro(zielwaehrung);
        return betrag.multiply(devisenkursFuerEuro);
    }

    private static boolean rechnungOhneDevisenkursProviderMoeglich(BigDecimal betrag, String ausgangswaehrung, String zielwaehrung) {
        return betrag.compareTo(BigDecimal.ZERO) == 0 || ausgangswaehrung.equals(zielwaehrung);
    }

    private static void checkInputs(BigDecimal betrag, String ausgangwaehrung, String zielwaehrung) {
        if (betrag == null || ausgangwaehrung ==null || zielwaehrung ==null) {
            throw new NullPointerException("betrag is null");
        }
        if (betrag.compareTo(BigDecimal.ZERO) <0) {
            throw new IllegalArgumentException("betrag is lower than 0");
        }
        if (ausgangwaehrung.length() != 3 || zielwaehrung.length() != 3) {
            throw new IllegalArgumentException("ungueltiges Waehrungssymbol");
        }
    }
}
