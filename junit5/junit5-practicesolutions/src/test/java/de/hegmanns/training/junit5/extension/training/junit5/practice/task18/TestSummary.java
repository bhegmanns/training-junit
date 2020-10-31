package de.hegmanns.training.junit5.extension.training.junit5.practice.task18;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestSummary implements InvocationInterceptor {

    private Map<String, Long> times = new HashMap<>();
    private int count;

    @Override
    public void interceptTestMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext, ExtensionContext extensionContext) throws Throwable {

        long startTime = System.currentTimeMillis();
        try {
            invocation.proceed();
        }finally{
            long finalTime = System.currentTimeMillis();

            long time = finalTime - startTime;
            System.out.println("" + invocationContext.getTargetClass().getSimpleName() + "." + invocationContext.getExecutable().getName() + " needed " + time + "ms");
            count++;
            times.put("" + count + ": " + invocationContext.getTargetClass().getSimpleName() + "." + invocationContext.getExecutable().getName(), time);
        }
    }


    @Override
    public void interceptAfterAllMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext, ExtensionContext extensionContext) throws Throwable {
        System.out.println("--- completed");
        times.entrySet().stream().forEach(System.out::println);
        invocation.proceed();
    }
}
