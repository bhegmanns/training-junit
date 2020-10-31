package de.hegmanns.training.junit5.extension.training.junit5.special.mock.testable;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GreetService01Test {

    @Test
    public void sixHourResultsInGoodMorning() {
        GreetService01 greetService = new GreetService01();
        greetService.setHourForTestCase(6);

        String greet = greetService.greet("Bernd");
        MatcherAssert.assertThat(greet, Matchers.is("Good Morning, Bernd"));

        greetService.resetTestCase();
    }
}
