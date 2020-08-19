package de.hegmanns.training.junit5.managing.repeatedtest;

import com.sun.corba.se.impl.orbutil.RepIdDelegator;
import com.sun.javaws.progress.PreloaderPostEventListener;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepeatedExampleTest {

    private Counter counter;

    @BeforeAll
    public void initializeCounter() {
        counter = new Counter(0);
    }

    @AfterEach
    public void afterTestsDoIncrement() {
        counter.increment();;
    }

    @RepeatedTest(100)
    public void checkCounterValue(RepetitionInfo repetitionInfo) {
        MatcherAssert.assertThat(counter.getValue(), Matchers.is(repetitionInfo.getCurrentRepetition()-1));
    }

}