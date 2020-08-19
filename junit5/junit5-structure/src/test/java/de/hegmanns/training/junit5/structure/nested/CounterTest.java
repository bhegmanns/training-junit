package de.hegmanns.training.junit5.structure.nested;

import de.hegmanns.training.junit5.structure.Counter;
import org.junit.jupiter.api.*;

public class CounterTest {

    private Counter counter;
    private static final int INITIAL_VALUE = 5;

    @BeforeEach
    public void beforeAnyTest() {
        counter = new Counter(INITIAL_VALUE);
    }

    @Test
    public void createWithInitialValue() {
        Assertions.assertEquals(INITIAL_VALUE, counter.getValue());
    }

    @Nested
    @DisplayName("Reset counter")
    class Resetting {

        @Test
        public void resetWithoutIncrementAndDecrement() {
            counter.reset();

            Assertions.assertEquals(INITIAL_VALUE, counter.getValue());
        }

        @Test
        public void resetAfterIncrement() {
            counter.increment();

            counter.reset();

            Assertions.assertEquals(INITIAL_VALUE, counter.getValue());
        }
    }

    @Nested
    @DisplayName("Increment counter")
    class Incrementing{

        @Test
        public void onceIncrement() {
            counter.increment();

            Assertions.assertEquals(INITIAL_VALUE+1, counter.getValue());
        }

        public void incrementTwiceTimes() {
            counter.increment();
            counter.increment();

            Assertions.assertEquals(INITIAL_VALUE+2, counter.getValue());
        }
    }

}
