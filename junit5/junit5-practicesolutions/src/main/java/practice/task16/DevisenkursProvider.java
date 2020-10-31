package practice.task16;

import java.math.BigDecimal;

public interface DevisenkursProvider {

    BigDecimal getDevisenkursFuerEuro(String waehrung);
}
