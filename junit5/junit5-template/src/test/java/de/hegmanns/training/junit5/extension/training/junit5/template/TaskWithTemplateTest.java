package de.hegmanns.training.junit5.extension.training.junit5.template;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

public class TaskWithTemplateTest {


    @TestTemplate
    @ExtendWith(TaskPossibleActionTestCaseProvider.class)
    public void testForTaskForActionTestCase(TaskForActionTestCase testCase) {
        //
    }


    @TestTemplate
    @ExtendWith(TaskPossibleActionTestCaseProvider.class)
    public void testForTaskForActionTestCase(TaskState state, TaskAction action) {
        //
    }

}
