package de.hegmanns.training.junit5.extension.training.junit5.practice.task10;

public interface MyComparator<T> extends Comparable<T> {


    int compare(T value1, T value2);
}
