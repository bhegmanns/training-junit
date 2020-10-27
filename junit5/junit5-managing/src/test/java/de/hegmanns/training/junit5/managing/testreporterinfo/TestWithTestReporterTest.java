package de.hegmanns.training.junit5.managing.testreporterinfo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import java.lang.reflect.Method;
import java.util.Optional;

public class TestWithTestReporterTest {

    public TestWithTestReporterTest(TestReporter testReporter, TestInfo testInfo) {
        printOut(testReporter, testInfo);
    }

    @Test
    public void withReporter(TestReporter testReporter) {
        printOut(testReporter, null);
    }

    @Test
    public void withReporterAndInfo(TestReporter testReporter, TestInfo testInfo) {

        printOut(testReporter, testInfo);
        Assertions.fail(testInfo.getTestMethod() + "....");
    }



    private void printOut(TestReporter testReporter, TestInfo testInfo) {
        Optional<TestInfo> testInfoOptional = Optional.ofNullable(testInfo);
        testReporter.publishEntry("" + testInfoOptional.flatMap(TestInfo::getTestClass).map(Class::getName).orElse(" not present ") + "." + testInfoOptional.flatMap(TestInfo::getTestMethod).map(Method::getName).orElse(" not present "));
        testReporter.publishEntry("display: " + testInfoOptional.map(TestInfo::getDisplayName).orElse(" not present "));
        testReporter.publishEntry(".");
    }
}
