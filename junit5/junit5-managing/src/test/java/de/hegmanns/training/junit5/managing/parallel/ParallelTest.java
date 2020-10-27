package de.hegmanns.training.junit5.managing.parallel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelTest {

    @Test
    void test01() {
        System.out.println(Thread.currentThread().getName() + " test01");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void test02() {
        System.out.println(Thread.currentThread().getName() + " test02");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test03() {
        System.out.println(Thread.currentThread().getName() + " test03");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
