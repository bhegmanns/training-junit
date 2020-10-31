package de.hegmanns.training.junit5.extension.training.junit5.managing.parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.*;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelWithLocksTest {

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
    public void test01() {
        Assertions.assertNull(System.getProperty("hegi.property"));
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    public void test02() {
        System.setProperty("hegi.property", "junit-5");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("junit-5", System.getProperty("hegi.property"));
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    public void test03() {
        System.setProperty("hegi.property", "JAVA");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("JAVA", System.getProperty("hegi.property"));
    }
}
