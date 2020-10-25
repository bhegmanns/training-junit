package de.hegmanns.training.junit5.special.mock.testable;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetService04Test {

    @Mock
    private HourProvider hourProvider;

    @InjectMocks
    private GreetService04 greetService;

    @Test
    public void sixHourResultsInGoodMorning_handling01() {
        shouldBeTimeAtHour(6);

        String greet = greetService.greet("Bernd");
        MatcherAssert.assertThat(greet, Matchers.is("Good Morning, Bernd"));
    }

    private void shouldBeTimeAtHour(int hour) {
        Mockito.when(hourProvider.getCurrentHour()).thenReturn(hour);
    }
}
