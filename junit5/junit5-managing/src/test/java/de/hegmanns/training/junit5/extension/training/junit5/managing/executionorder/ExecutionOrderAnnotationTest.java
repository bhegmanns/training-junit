package de.hegmanns.training.junit5.extension.training.junit5.managing.executionorder;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecutionOrderAnnotationTest {


    @Test
    @Order(2)
    public void secondExecution() {

    }

    @Test
    @Order(1)
    public void firstExecution() {

    }

    @Test
    @Order(3)
    public void thirdExecution() {

    }
}
