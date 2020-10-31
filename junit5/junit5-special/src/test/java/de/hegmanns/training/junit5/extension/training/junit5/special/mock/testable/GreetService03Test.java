package de.hegmanns.training.junit5.extension.training.junit5.special.mock.testable;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetService03Test {

    @Mock
    HourProvider hourProvider;

    @InjectMocks
    GreetService03 greetService;


    @Test
    public void sixHourResultsInGoodMorning_handling01() {
        HourProvider hourProvider = Mockito.mock(HourProvider.class);
        Mockito.when(hourProvider.getCurrentHour()).thenReturn(6);
        GreetService03 greetService = new GreetService03();
        greetService.setHourProvider(hourProvider);

        String greet = greetService.greet("Bernd");
        MatcherAssert.assertThat(greet, Matchers.is("Good Morning, Bernd"));
    }

    @Test
    public void sixHourResultsInGoodMorning_handling02() {
        shouldBeTimeAtHour(6);

        String greet = greetService.greet("Bernd");
        MatcherAssert.assertThat(greet, Matchers.is("Good Morning, Bernd"));
    }

    private void shouldBeTimeAtHour(int hour) {
        Mockito.when(hourProvider.getCurrentHour()).then((d) -> {
            try{Thread.sleep(2000);}catch(Exception e){}
            return hour;
        });
    }
}
