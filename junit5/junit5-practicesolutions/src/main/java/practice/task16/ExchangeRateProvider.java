package practice.task16;

import java.math.BigDecimal;

public interface ExchangeRateProvider {

    BigDecimal getExchangeRateForEuro(String currency);
}
