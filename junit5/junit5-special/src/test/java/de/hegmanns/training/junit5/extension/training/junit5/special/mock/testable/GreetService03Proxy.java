package de.hegmanns.training.junit5.extension.training.junit5.special.mock.testable;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GreetService03Proxy {
    @Test
    public void greetOnMorning() {
        GreetService03 greetService03 = new GreetService03();

        HourProviderForTest providerForTest = new HourProviderForTest(11);

        greetService03.setHourProvider(providerForTest);

        MatcherAssert.assertThat("Good Morning, Bernd", Matchers.is(greetService03.greet("Bernd")));
        MatcherAssert.assertThat(providerForTest.isCurrentHourUsed(), Matchers.is(true));
    }

    private static class HourProviderForTest extends HourProvider {

        private int currentHour;
        private boolean currentHourUsed = false;
        public HourProviderForTest(int currentHour) {
            this.currentHour = currentHour;
        }
        @Override
        public int getCurrentHour() {
            currentHourUsed=true;
            return currentHour;
        }

        public boolean isCurrentHourUsed() {
            return currentHourUsed;
        }
    }

}
