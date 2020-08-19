package de.hegmanns.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Test;

public class WorkingWithConditionTest {

    @Test
    @HegiCondition
    public void dontWorkWithHegi() {

    }

    @Test
    @HegiCondition(info = "it's too sunny")
    public void dontWorkWithHegiToo() {

    }
}
