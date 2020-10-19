package de.hegmanns.training.junit5.managing.suites;

import org.junit.Test;
import org.junit.platform.suite.api.SelectClasses;

@SelectClasses({SingleTest.class, OtherSingleTest.class})
public class MySuiteTest {

    @Test
    public void testInMySuite() {

    }
}
