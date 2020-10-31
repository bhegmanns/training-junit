package de.hegmanns.training.junit5.extension.training.junit5.practice.task07.step01;

import de.hegmanns.training.junit5.extension.training.junit5.practice.task07.DisableOnTime;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.AnnotatedElement;
import java.time.LocalTime;
import java.util.Optional;

public class DisableOnTimeCondition implements ExecutionCondition {

    public static boolean isOnTime(String from, String until) {
        return true;
    }
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        Optional<AnnotatedElement> element = extensionContext.getElement();
        if (element.isPresent()) {
            DisableOnTime annotation = element.get().getAnnotation(DisableOnTime.class);
            if (annotation != null) {
                String fromString = annotation.from();
                String untilString = annotation.until();

                LocalTime from = LocalTime.parse(fromString);
                LocalTime until = LocalTime.parse(untilString);
                LocalTime now = LocalTime.now();

                if (now.isBefore(from)) {
                    return ConditionEvaluationResult.enabled("ok");
                }
                if (now.isAfter(until)) {
                    return ConditionEvaluationResult.enabled("ok");
                }
            }
        }
        return ConditionEvaluationResult.disabled("not in time");
    }
}

