package de.hegmanns.training.junit5.practice.task10;

public class CommonTestForFloatTest implements CommonTestInterface<Float>{

    @Override
    public Float getLowerValue() {
        return 1.1f;
    }

    @Override
    public Float getHigherValue() {
        return 10f;
    }
}
