package de.hegmanns.training.junit.special.parameterized;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParameterizedTest {

    @DisplayName("lessTest")
    @org.junit.jupiter.params.ParameterizedTest(name = "{arguments} should be less than 100")
    @ValueSource(ints = {1, 2, 56, 99})
    public void withSimpleList(int value) {
        MatcherAssert.assertThat(value, Matchers.lessThan(100));
    }

    @DisplayName("lessTest")
    @org.junit.jupiter.params.ParameterizedTest(name = "{0} should be less than {1}")
    @CsvSource({"1, 2", "5, 10", "999, 1000"})
    public void twoParameters(int first, int second) {
        MatcherAssert.assertThat(first, Matchers.lessThan(second));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("paramsForTest")
    public void viaMethod(int value) {
        MatcherAssert.assertThat(value, Matchers.lessThan(100));
    }

    private static Stream<Integer> paramsForTest() {
        return Stream.of(1, 2, 5, 10, 99);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ArgumentsSource(MyArgumentProvider.class)
    public void argument(String param) {
        System.out.println(param);
    }

    private static class MyArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of("hello", "world").map(Arguments::of);
        }
    }

}
