package de.hegmanns.training.junit5.parameter.order;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class OrderType2OrderzusatzCheckTest {

    @ParameterizedTest

    @ArgumentsSource(A.class)
    public void checkPromittedZusatzForType(OrderType orderType, Orderzusatz orderzusatz) {
        System.out.println("" + orderType + " : " + orderzusatz);

    }

    public static class A implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(Arguments.arguments(OrderType.A, Orderzusatz.AUCTION));
        }
    }

}
