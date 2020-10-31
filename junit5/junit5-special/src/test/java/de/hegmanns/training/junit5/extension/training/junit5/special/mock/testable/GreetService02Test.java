package de.hegmanns.training.junit5.extension.training.junit5.special.mock.testable;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class GreetService02Test {

//    @Test
//    public void foo() {
//        System.out.println(LocalTime.now());
//
//        Clock fixedByParse = Clock.fixed(Instant.parse("2020-01-01T06:00:00.00Z"), ZoneId.systemDefault());
//        System.out.println(LocalTime.now(fixedByParse));
//
//        Clock fixed = Clock.fixed(Instant.ofEpochSecond(60 * 60 * 6), ZoneId.systemDefault());
//        System.out.println(LocalTime.now(fixed));
//
//
//    }

    @Test
    public void sixHourResultsInGoodMorning_handling01() {
        GreetService02 greetService = new GreetService02();
        int sixHours = 60 * 60 * 6;
        greetService.setClock(Clock.fixed(Instant.ofEpochSecond(sixHours), ZoneId.systemDefault()));

        String greet = greetService.greet("Bernd");
        MatcherAssert.assertThat(greet, Matchers.is("Good Morning, Bernd"));
    }


}
