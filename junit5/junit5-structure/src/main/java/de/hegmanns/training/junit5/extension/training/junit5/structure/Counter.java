package de.hegmanns.training.junit5.extension.training.junit5.structure;

public class Counter {

    private int value;
    private int initialValue;

    public Counter(int initialValue) {
        this.value = initialValue;
        this.initialValue = value;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void reset() {
        this.value = initialValue;
    }
}
