package de.hegmanns.training.junit5.extension.training.junit5.practice.task07.step02;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;

public class NoLongTestCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
//        String noLongTestProperty = System.getProperty("no.long.tests");
//        if (noLongTestProperty == null || !noLongTestProperty.equals("true")) {
//            return ConditionEvaluationResult.enabled("no.long.tests property not set or not set to true");
//        }
        Optional<String> testMethodName = extensionContext.getTestMethod().map(Method::getName).map(String::toLowerCase);

        Integer positionOfLongInTestMethodName = testMethodName.map((s) -> s.indexOf("long")).orElse(-1);

        if (positionOfLongInTestMethodName == -1) {
            return ConditionEvaluationResult.enabled("ok");
        }else{

            return ConditionEvaluationResult.disabled("name " + testMethodName.orElse("") +  " contains 'long'");
        }
    }
}
