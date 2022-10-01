package practice.task16;

import java.math.BigDecimal;

public class ExchangeConverter {

    public static ExchangeRateProvider provider;
    public static BigDecimal convert(BigDecimal amount, String startCurrency, String targetCurrency) {
        checkInputs(amount, startCurrency, targetCurrency);
        if (convertWithoutExchangeRateProviderPossible(amount, startCurrency, targetCurrency)) {
            if (amount.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            } else {
                if (startCurrency.equals(targetCurrency)) {
                    return amount;
                }
            }
        }


        BigDecimal exchangeRateForEuro = provider.getExchangeRateForEuro(targetCurrency);
        return amount.multiply(exchangeRateForEuro);
    }

    private static boolean convertWithoutExchangeRateProviderPossible(BigDecimal amount, String startCurrency, String targetCurrency) {
        return amount.compareTo(BigDecimal.ZERO) == 0 || startCurrency.equals(targetCurrency);
    }

    private static void checkInputs(BigDecimal amount, String startCurrency, String targetCurrency) {
        if (amount == null || startCurrency ==null || targetCurrency ==null) {
            throw new NullPointerException("betrag is null");
        }
        if (amount.compareTo(BigDecimal.ZERO) <0) {
            throw new IllegalArgumentException("betrag is lower than 0");
        }
        if (startCurrency.length() != 3 || targetCurrency.length() != 3) {
            throw new IllegalArgumentException("ungueltiges Waehrungssymbol");
        }
    }
}
