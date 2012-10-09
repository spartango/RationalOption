package com.perceptus.option;

import java.util.HashSet;
import java.util.Set;

public class Present<T, E extends Exception> extends Option<T, E> {
    private static final int MAGIC = 0x598df91c;

    private final T          value;

    public Present(T value) {
        this.value = value;
    }

    @Override public boolean isPresent() {
        return true;
    }

    @Override public T get() {
        return value;
    }

    @Override public T or(T defaultValue) {
        return value;
    }

    @Override public T orNull() {
        return value;
    }

    @Override public Set<T> asSet() {
        Set<T> set = new HashSet<>();
        set.add(value);
        return set;
    }

    @Override public boolean hasException() {
        return false;
    }

    @Override public E getException() {
        throw new IllegalStateException("No exception present");
    }

    @Override public boolean equals(Object object) {
        if (object instanceof Present) {
            Present<?, ?> other = (Present<?, ?>) object;
            return value.equals(other.value);
        }
        return false;
    }

    @Override public int hashCode() {
        return MAGIC + value.hashCode();
    }

    @Override public String toString() {
        return "Present(" + value + ")";
    }

}
