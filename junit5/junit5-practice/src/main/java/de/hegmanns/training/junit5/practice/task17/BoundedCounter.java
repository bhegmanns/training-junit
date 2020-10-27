package de.hegmanns.training.junit5.practice.task17;

public class BoundedCounter extends Counter{
    private int minimum;
    private int maximum;

    public BoundedCounter(int initialValue, int minimum, int maximum) {
        super(initialValue);
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public void increment() {
        if (getValue() < maximum) {
            super.increment();
        }
    }

    @Override
    public void decrement() {
        if (getValue() > minimum) {
            super.decrement();
        }
    }
}
