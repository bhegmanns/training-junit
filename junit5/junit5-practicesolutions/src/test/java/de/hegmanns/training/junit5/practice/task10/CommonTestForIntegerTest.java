package de.hegmanns.training.junit5.practice.task10;

public class CommonTestForIntegerTest implements CommonTestInterface<Integer>{

    @Override
    public Integer getLowerValue() {
        return 1;
    }

    @Override
    public Integer getHigherValue() {
        return 10;
    }
}
