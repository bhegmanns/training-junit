package de.hegmanns.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;

public class HegiSampleTestCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        Optional<AnnotatedElement> element = extensionContext.getElement();

        if (element.isPresent()) {
            HegiCondition annotation = element.get().getAnnotation(HegiCondition.class);
            if (annotation != null) {
                String info = annotation.info();
                if (annotation.weather().equals("sunny")) {
                    if (isSunny()) {
                        return ConditionEvaluationResult.enabled("ok, is sunny");
                    }else{
                        return ConditionEvaluationResult.disabled("uuuh, is rainy");
                    }
                }
                return ConditionEvaluationResult.disabled("don't have time for proceeding this boring test: " + info);
            }
        }
        return ConditionEvaluationResult.enabled("..");
    }

    private boolean isSunny() {
        // request to weather station

        return true; // false
    }
}
