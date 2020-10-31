package de.hegmanns.training.junit5.extension.training.junit5.managing.repeatedtest;

public class Counter {

    private int value;

    public Counter(int initial) {
        System.out.println("call Counter(" + initial + ")");
        this.value = initial;
    }

    public void increment() {
        this.value++;
    }

    public void decrement() {
        this.value--;
    }

    public int getValue() {
        return this.value;
    }
}
