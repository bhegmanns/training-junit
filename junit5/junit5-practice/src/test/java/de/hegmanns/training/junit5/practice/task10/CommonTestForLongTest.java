package de.hegmanns.training.junit5.practice.task10;

public class CommonTestForLongTest implements CommonTestInterface<Long> {
    @Override
    public Long getLowerValue() {
        return 0l;
    }

    @Override
    public Long getHigherValue() {
        return 100l;
    }
}
