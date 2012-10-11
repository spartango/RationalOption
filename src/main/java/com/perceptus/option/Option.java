package com.perceptus.option;

import java.io.Serializable;
import java.util.Set;

public abstract class Option<T, E extends Exception> implements Serializable {

    private static final long serialVersionUID = -4869775898819966212L;

    public static <T, E extends Exception> Option<T, E> absent(E exception) {
        return new Absent<T, E>(exception);
    }

    public static <T, E extends Exception> Option<T, E> of(T value) {
        return new Present<T, E>(checkNotNull(value));
    }

    public abstract boolean isPresent();

    public abstract T get();

    public abstract T or(T defaultValue);

    public abstract T orNull();

    public abstract Set<T> asSet();

    public abstract boolean hasException();

    public abstract E getException();

    private static <T> T checkNotNull(T value) {
        if (value == null) {
            throw new IllegalStateException("Value is null");
        } else {
            return value;
        }
    }

    @Override public abstract boolean equals(Object object);

    @Override public abstract int hashCode();

    @Override public abstract String toString();
}
