package de.hegmanns.training.junit5.extension.training.junit5.structure.testinterface;

public interface Accessor<T, U> {

    U getValueFrom(T instance);
}
