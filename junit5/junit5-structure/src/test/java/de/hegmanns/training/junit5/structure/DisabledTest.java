package de.hegmanns.training.junit5.structure;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisabledTest {

    @Test
    @Disabled
    public void disabledTestWithoutReason() {

    }

    @Test
    @Disabled("the test goes red, but I don't know the reason ...")
    public void disabledTestBySillyReason() {

    }

    @Test
    @DisplayName("will be solved by issue #12")
    public void domainTest() {

    }

    @Test
    @Disabled("😱")
    public void disabled() {

    }

    @Test
    @Disabled("╯°□°）╯")
    public void disabledToo() {

    }

//    @Test
//    @Disabled("will be activated with Task AB-123")
//    public void disabledTestByReasonWithTask() {
//
//    }
//
//    @Test
//    @Disabled("since Task RF-007")
//    public void disabledByRefactoringReason() {
//
//    }
}

