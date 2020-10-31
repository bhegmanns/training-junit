package de.hegmanns.training.junit5.extension.training.junit5.practice.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice.task04.BoundedCounter;

import java.util.ArrayList;
import java.util.List;

public class BoundedCounterTest {

    private BoundedCounter anyCounter;
    private int initialValue;


    @BeforeEach
    public void beforeAnyTest() {
        initialValue = 10;
        anyCounter = new BoundedCounter(initialValue, 0, 20);
    }

    @Test
    public void boundedCounterIncrementsBetweenHisBounds() {

        int currentValue = anyCounter.getValue();

        Assertions.assertNotEquals(currentValue, anyCounter.increment());
    }

    @Test
    public void boundedCounterIncrementsByOne() {

        Assertions.assertEquals(initialValue+1, anyCounter.increment());
    }

    @Test
    public void boundedCounterDoesntIncrementAboveMaximum() {

        for (int i = 0; i < 100; i++) {
            anyCounter.increment();
        }

        Assertions.assertEquals(20, anyCounter.getValue());
    }

    @Test
    public void boundedCounterWorksPolymorphic() {

        for (int i = 0; i < 100; i++) {
            anyCounter.increment();
        }

        Assertions.assertEquals(20, anyCounter.getValue());
    }

    @Test
    public void testForall() {
        List<Executable> allExecutables = new ArrayList<>();

        // generierung/Parametrierung
        allExecutables.add(create(100, 20));
        allExecutables.add(create(1, 20));
        allExecutables.add(create(200, 20));

        Assertions.assertAll(allExecutables);
    }

    private Executable create(int countIncrements, int expectedValue){
        return ()-> {
            for (int i = 0; i < countIncrements; i++) {
                anyCounter.increment();
            }
            Assertions.assertEquals(expectedValue, anyCounter.getValue());
        };
    }

    public void incrementWithExpectedValue(int countIncrements, int expectedValue) {

    }

    @DisplayName("Test fuer Counter")
    @ParameterizedTest(name = "{index}. Test: {displayName}: Counter {0} mal inkrementiert ergibt ...")
    @ValueSource(ints = {1, 2, 3, 10, 20})
    public void doTest(int value) {
        System.out.println("Wert = " + value);
    }
}
