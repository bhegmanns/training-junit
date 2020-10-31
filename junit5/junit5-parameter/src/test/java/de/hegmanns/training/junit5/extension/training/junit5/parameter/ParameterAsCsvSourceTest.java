package de.hegmanns.training.junit5.extension.training.junit5.parameter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.TypedArgumentConverter;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ParameterAsCsvSourceTest {

    @DisplayName("check for odd: ")
    @ParameterizedTest(name = "{0} should be odd")
    @CsvSource({"1", "5", "11", "15", "33"})
    public void isOdd(int value) {
        Assertions.assertTrue(value % 2 == 1);
    }

    @DisplayName("check for divisor: ")
    @ParameterizedTest(name = "{1} should be a divisor of {0}")
    @CsvSource({"6, 3", "8, 2", "10, 5", "15, 3", "33, 11"})
    public void isDivisor(int number, int divisor) {
        Assertions.assertTrue(number % divisor == 0);
    }

    @DisplayName("handleWithString")
    @ParameterizedTest
    @EmptySource
    @NullSource
    @CsvSource({"a"})
    public void handleWithString(String string) {
        System.out.println("Value = '" + string + "'");
    }

    @DisplayName("handleWithAlternativeNull")
    @ParameterizedTest
    @EmptySource
    @CsvSource(value = {"a", "b", "NULL", "c", "d", "e"}, nullValues = "NULL")
    public void handleWithAlternativeNull(String string) {
        System.out.println("value = '" + string + "'");
    }

    @DisplayName("check for divisor: ")
    @ParameterizedTest(name = "{1} are all possible divisors of {0}")
    @CsvSource({"6, '1, 2, 3, 6'", "4, '1, 2, 4'", "8, '1, 2, 4, 8'", "10, '1, 2, 5, 10'", "15, '1, 3, 5, 15'", "33, '1, 3, 11, 33'"})
    public void allDivisorsWithConverter(int number, @ConvertWith(StringToIntArrayConverter.class) int[] allPossibleDivisors) {
        System.out.println("" + number + " have " + allPossibleDivisors.length + " divisors");
    }




    public static class StringToIntArrayConverter extends TypedArgumentConverter<String, int[]> {

        protected StringToIntArrayConverter() {
            super(String.class, int[].class);
        }

        @Override
        protected int[] convert(String s) throws ArgumentConversionException {
            return Stream.of(s.split(", "))
                    .mapToInt(Integer::valueOf).toArray();
        }
    }

    @DisplayName("check for divisor: ")
    @ParameterizedTest(name = "{1} are all possible divisors of {0}")
    @CsvSource({"6, 1, 2, 3, 6", "4, 1, 2, 4", "8, 1, 2, 4, 8", "10, 1, 2, 5, 10", "15, 1, 3, 5, 15", "33, 1, 3, 11, 33"})
    public void allDivisorsWithAggregator(int number,  @AggregateWith(StringToIntArrayAggregator.class)  int[] allPossibleDivisors) {
        System.out.println("" + number + " have " + allPossibleDivisors.length + " divisors");
    }

    public static class StringToIntArrayAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            ArrayList<Object> argumentsAsList = new ArrayList<>(argumentsAccessor.toList());
            argumentsAsList.remove(0);


            return argumentsAsList.stream()
                    .map(Object::toString)
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testvalues.csv")
    public void foo2(String word, int expectedLength) {
        System.out.println(word + ": " + expectedLength);
    }

}
