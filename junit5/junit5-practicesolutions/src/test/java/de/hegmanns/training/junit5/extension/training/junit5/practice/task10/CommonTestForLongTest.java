package de.hegmanns.training.junit5.extension.training.junit5.practice.task10;

public class CommonTestForLongTest implements CommonTestInterface<Long> {

    @Override
    public Long getLowerValue() {
        return 1l;
    }

    @Override
    public Long getHigherValue() {
        return 10l;
    }
}
