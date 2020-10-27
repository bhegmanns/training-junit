package de.hegmanns.training.junit.special.parameterized;

import de.hegmanns.training.junit5.special.stocks.Exchange;
import de.hegmanns.training.junit5.special.stocks.Order;
import de.hegmanns.training.junit5.special.stocks.Stock;
import de.hegmanns.training.junit5.special.stocks.validator.Supplement;
import de.hegmanns.training.junit5.special.stocks.validator.SupplementLocator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AggregatorTest {

    SupplementLocator locator;

    @BeforeEach
    public void beforeAnyTest() {
        locator = new SupplementLocator();
    }

    @ParameterizedTest
    @CsvSource({"A, XETRA, LIMIT", "A, XETRA, AUCTION_ONLY"})
    public void containsInPossibleSupplements(ArgumentsAccessor argumentsAccessor) {
        String xetraType = argumentsAccessor.getString(0);
        String exchange = argumentsAccessor.getString(1);
        Supplement expectedSupplement = Supplement.valueOf(argumentsAccessor.getString(2));

        Exchange xetra = new Exchange();
        xetra.setId("123");
        xetra.setExchangeName(exchange);

        Stock anyStock = new Stock();
        anyStock.setStockName("anyName");
        anyStock.setXetraType(xetraType);

        Order anyOrderExpireToday = new Order();
        anyOrderExpireToday.setExpireDate(LocalDate.now());
        anyOrderExpireToday.setExchange(xetra);
        anyOrderExpireToday.setStock(anyStock);

        Assertions.assertThat(locator.getPossibleSupplements(anyOrderExpireToday)).containsAnyOf(expectedSupplement);
    }


    @ParameterizedTest
    @CsvSource({"A, XETRA, LIMIT", "A, XETRA, AUCTION_ONLY"})
    public void containsInPossibleSupplementsWithAggregator(@AggregateWith(OrderAggregator.class) Map<Order, Supplement> orderAndExpectedSupplement) {
        Map.Entry<Order, Supplement> entry = orderAndExpectedSupplement.entrySet().iterator().next();
        Assertions.assertThat(locator.getPossibleSupplements(entry.getKey())).containsAnyOf(entry.getValue());
    }

    @ParameterizedTest
    @CsvSource({"A, XETRA, LIMIT", "A, XETRA, AUCTION_ONLY"})
    public void containsInPossibleSupplementsWithAggregatorInAnnotation(@ToOrderAggregate Map<Order, Supplement> orderAndExpectedSupplement) {
        Map.Entry<Order, Supplement> entry = orderAndExpectedSupplement.entrySet().iterator().next();
        Assertions.assertThat(locator.getPossibleSupplements(entry.getKey())).containsAnyOf(entry.getValue());
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    @AggregateWith(OrderAggregator.class)
    static @interface ToOrderAggregate{

    }

    static class OrderAggregator implements ArgumentsAggregator {


        @Override
        public Map<Order, Supplement> aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            String xetraType = argumentsAccessor.getString(0);
            String exchange = argumentsAccessor.getString(1);
            Supplement expectedSupplement = Supplement.valueOf(argumentsAccessor.getString(2));

            Exchange xetra = new Exchange();
            xetra.setId("123");
            xetra.setExchangeName(exchange);

            Stock anyStock = new Stock();
            anyStock.setStockName("anyName");
            anyStock.setXetraType(xetraType);

            Order anyOrderExpireToday = new Order();
            anyOrderExpireToday.setExpireDate(LocalDate.now());
            anyOrderExpireToday.setExchange(xetra);
            anyOrderExpireToday.setStock(anyStock);

            Map<Order, Supplement> map = new HashMap<>();
            map.put(anyOrderExpireToday, expectedSupplement);
            return map;
        }
    }
}