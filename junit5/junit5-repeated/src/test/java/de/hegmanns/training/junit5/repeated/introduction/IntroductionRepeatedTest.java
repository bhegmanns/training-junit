package de.hegmanns.training.junit5.repeated.introduction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class IntroductionRepeatedTest {

    @RepeatedTest(5) // count of repetitions
//    @Test <<< @Test-annotation is forbidden
    public void simpleTestMethod() {
        System.out.println("a repetition :)");
    }

    @RepeatedTest(5)
    public void testMethodWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        // this are your infos propagated by RepetitionInfo
        repetitionInfo.getCurrentRepetition(); // will start by 1
        repetitionInfo.getTotalRepetitions();

        System.out.println("repetition " + repetitionInfo.getCurrentRepetition() + " from " + repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 5,name = "very simple test {currentRepetition} / {totalRepetition}")
    public void testMethodWithCommonDisplayName(RepetitionInfo repetitionInfo) {
        // stays empty
    }

    @DisplayName("here are some tests")
    @RepeatedTest(value = 5, name="other simple test {currentRepetition}")
    public void testMethodWithCommonDisplayNameForEachIterationAndMethodDisplayName() {

    }

    /*
    NOTE:
    Do not combine parameterized test with repeated test !
     */
//    @RepeatedTest(value = 5)
//    @ParameterizedTest
//    @ValueSource(ints = {1, 2, 3})
//    public void testWithRepetitionAndParameter(int value) {
//
//    }
}
