package de.hegmanns.training.junit5.extension.exceptionhandler;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ExceptionExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {

        if (throwable instanceof RuntimeException) {
            System.out.println("oh, only a RuntimeException: " + throwable.getClass());
        } else {
            throw throwable;
        }
    }
}
