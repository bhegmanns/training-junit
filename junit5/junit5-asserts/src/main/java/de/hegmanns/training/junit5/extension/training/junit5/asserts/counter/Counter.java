package de.hegmanns.training.junit5.extension.training.junit5.asserts.counter;

public interface Counter<T> {

    void increment();

    void decrement();

    T getValue();
}
