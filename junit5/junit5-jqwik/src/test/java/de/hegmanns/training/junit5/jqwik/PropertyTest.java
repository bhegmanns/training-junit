package de.hegmanns.training.junit5.jqwik;

import net.jqwik.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PropertyTest {

    @Property
    boolean every_third_element_starts_with_fizz(@ForAll("divisibleBy3") int i) {
        return buzzer().get(i - 1).startsWith("FIZZ");
    }

    @Provide
    Arbitrary<Integer> divisibleBy3() {
        return Arbitraries.integers().between(1, 100).map((i) -> i*3).filter((i) -> i<100);
    }

    private List<String> buzzer() {
        return IntStream.range(1, 100).mapToObj((int i) -> {
            boolean dividableBy3 = i % 3 == 0;
            boolean dividableBy5 = i % 5 == 5;

            return dividableBy3 && dividableBy5 ? "FIZZBUZZ"
                    : dividableBy3 ? "FIZZ"
                    : dividableBy5 ? "BUZZ"
                    : "" + i;
        }).collect(Collectors.toList());
    }
}
