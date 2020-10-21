package de.hegmanns.training.junit.special.mockito;

import de.hegmanns.training.junit5.special.mock.GreetService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalTime;

public class StaticMockTest {

    @Test
    public void workingWithStaticMethod() {
        try (MockedStatic<GreetService> greetServiceMockedStatic = Mockito.mockStatic(GreetService.class)){
            greetServiceMockedStatic.when(GreetService::sayHello).thenReturn("Huhu");

            MatcherAssert.assertThat(GreetService.sayHello(), Matchers.startsWith("Huhu"));
        }
    }

    @Test
    public void workingWithStaticCore() {
        LocalTime of = LocalTime.of(11, 55);

        try(MockedStatic<LocalTime> localTimeMockedStatic = Mockito.mockStatic(LocalTime.class)){
            localTimeMockedStatic.when(LocalTime::now).thenReturn(of);
            MatcherAssert.assertThat(GreetService.sayHello(), Matchers.endsWith("11"));
        }
    }
}
