package de.hegmanns.training.junit5.practice.task04;

public class Counter {

    private int value;

    public Counter(int initial) {
        this.value = initial;
    }

    public int increment() {
        return ++value;
    }

    public int decrement() {
        return --value;
    }

    public int getValue() {
        return value;
    }
}
