package de.hegmanns.training.junit5.extension.training.junit5.practice.task04;

public class Counter {

    private int value;

    private int countIncrements;
    private int countDecrements;

    public Counter(int initial) {
        this.value = initial;
    }

    public Counter(){
        this(0);
    }

    public int increment() {
        countIncrements++; return ++value;
    }

    public int decrement() {
        countDecrements++; return --value;
    }

    public int getValue() {
        return value;
    }

    public int getCountIncrements() {
        return countIncrements;
    }

    public int getCountDecrements() {
        return countDecrements;
    }

    public int getCountOperations() {
        return getCountDecrements() + getCountIncrements();
    }
}
