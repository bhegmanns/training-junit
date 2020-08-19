package de.hegmanns.training.junit.special.template;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

public class NumberCheckWithTemplateTest {

    private NumberCheck numberCheck;

    @BeforeEach
    private void beforeAnyTest() {
        numberCheck = new NumberCheck();
    }


    @TestTemplate
    @ExtendWith(NumberCheckTestCaseProvider.class)
    public void checkIsPreferred(NumberCheckTestCase numberCheckTestCase) {
        numberCheck.setOddAsPreferred(numberCheckTestCase.isOddPreferred());

        MatcherAssert.assertThat(numberCheck.isPreferred(numberCheckTestCase.getNumber()), Matchers.is(numberCheckTestCase.isPreferred()));
    }
}
