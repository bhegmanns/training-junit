package de.hegmanns.training.junit5.extension.training.junit5.managing.parallel;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;
import java.util.Collection;


public class ConcurrentTest {

    @Execution(ExecutionMode.CONCURRENT)
    @TestFactory
    Collection<DynamicTest> parallel_concurrent() {
        return Arrays.asList(
          DynamicTest.dynamicTest("test 1.1", () -> {
              System.out.println(Thread.currentThread().getName() + ": test 1.1");
          }),
                DynamicTest.dynamicTest("test 1.2", () -> {
                    System.out.println(Thread.currentThread().getName() + ": test 1.2");
                }),
                DynamicTest.dynamicTest("test 1.3", () -> {
                    System.out.println(Thread.currentThread().getName() + ": test 1.3");
                })
        );
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    Collection<DynamicTest> parallel_samethread() {
        return Arrays.asList(
                DynamicTest.dynamicTest("test 2.1", () -> {
                    System.out.println(Thread.currentThread().getName() + ": test 2.1");
                }),
                DynamicTest.dynamicTest("test 2.2", () -> {
                    System.out.println(Thread.currentThread().getName() + ": test 2.2");
                }),
                DynamicTest.dynamicTest("test 2.3", () -> {
                    System.out.println(Thread.currentThread().getName() + ": test 2.3");
                })
        );
    }
}
