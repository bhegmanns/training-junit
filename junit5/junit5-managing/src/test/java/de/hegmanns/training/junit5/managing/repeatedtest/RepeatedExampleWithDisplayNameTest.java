package de.hegmanns.training.junit5.managing.repeatedtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedExampleWithDisplayNameTest {

    @RepeatedTest(value = 3, name = "Task {currentRepetition} from {totalRepetitions}")
    public void repeatedWithName() {

    }

    @RepeatedTest(value = 3, name = "{displayName}: {currentRepetition}. task from {totalRepetitions}")
    @DisplayName("This is a repeated test")
    public void repeatedWithNameAndDisplayName() {

    }
}


