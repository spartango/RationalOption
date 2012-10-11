package com.perceptus.option;

import java.util.HashSet;
import java.util.Set;

public class Absent<T, E extends Exception> extends Option<T, E> {
    /**
     * 
     */
    private static final long serialVersionUID = -4502256771784687414L;

    private static final int  MAGIC            = 0x598df91d;

    private final E           exception;

    public Absent(E exception) {
        this.exception = exception;
    }

    @Override public boolean isPresent() {
        return false;
    }

    @Override public T get() {
        throw new IllegalStateException("Not present");
    }

    @Override public T or(T defaultValue) {
        return defaultValue;
    }

    @Override public T orNull() {
        return null;
    }

    @Override public Set<T> asSet() {
        return new HashSet<>();
    }

    @Override public boolean hasException() {
        return exception != null;
    }

    @Override public E getException() {
        return exception;
    }

    @Override public boolean equals(Object object) {
        if (object instanceof Absent) {
            Absent<?, ?> other = (Absent<?, ?>) object;
            return exception.equals(other.exception);
        }
        return false;
    }

    @Override public int hashCode() {
        return MAGIC + exception.hashCode();
    }

    @Override public String toString() {
        return "Absent(" + exception + ")";
    }
}
