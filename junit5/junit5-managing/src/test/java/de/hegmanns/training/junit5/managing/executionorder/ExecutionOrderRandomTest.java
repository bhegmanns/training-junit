package de.hegmanns.training.junit5.managing.executionorder;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class ExecutionOrderRandomTest {

}
