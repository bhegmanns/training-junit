package de.hegmanns.training.junit5.extension.training.junit5.structure.testinterface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public interface TestInterface {

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("START " + testInfo.getDisplayName());
    }

    @AfterEach
    default void afterEach(TestInfo testInfo) {
        System.out.println("END " + testInfo.getDisplayName());
    }


}
