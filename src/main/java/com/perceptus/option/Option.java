package com.perceptus.option;

import java.io.Serializable;
import java.util.Set;

/**
 * An immutable object that may contain a non-null reference to another object.
 * Each instance of this type either contains a non-null reference, or contains
 * an exception describing why the reference isn't present
 * 
 * <p>
 * Some uses of this class include
 * 
 * <ul>
 * <li>As a method return type, as an alternative to returning {@code null} to
 * indicate that no value was available
 * <li>To distinguish between "unknown" (for example, not present in a map) and
 * "known to have no value" (present in the map, with value
 * {@code Optional.absent()})
 * </ul>
 * 
 * <p>
 * See the Guava User Guide article on <a href=
 * "http://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained#Optional"
 * > using {@code Optional}</a>.
 * 
 * This class imitates the API laid out by <a
 * href="http://code.google.com/p/guava-libraries/">Google Guava</a> but
 * augments it substantially.
 * 
 * For more information, visit the <a
 * href="https://github.com/spartango/RationalOption">project page</a>
 * 
 * @param <T>
 *            the type of instance that can be contained.
 * @param <E>
 *            the type of Exception that might be contained instead of a value.
 * 
 */
public abstract class Option<T, E extends Exception> implements Serializable {

    private static final long serialVersionUID = -4869775898819966212L;

    /**
     * Returns an {@code Optional} instance with no contained reference, and an
     * exception explaining why.
     */
    public static <T, E extends Exception> Option<T, E> absent(E exception) {
        return new Absent<T, E>(exception);
    }

    /**
     * Returns an {@code Optional} instance containing the given non-null
     * reference.
     */
    public static <T, E extends Exception> Option<T, E> of(T value) {
        return new Present<T, E>(checkNotNull(value));
    }

    /**
     * Returns {@code true} if this holder contains a (non-null) instance and no
     * exception.
     */
    public abstract boolean isPresent();

    /**
     * Returns the contained instance, which must be present. If the instance
     * might be absent, use {@link #or(Object)} or {@link #orNull} instead.
     * 
     * @throws IllegalStateException
     *             if the instance is absent ({@link #isPresent} returns
     *             {@code false})
     */
    public abstract T get();

    /**
     * Returns the contained instance if it is present; {@code defaultValue}
     * otherwise. If no default value should be required because the instance is
     * known to be present, use {@link #get()} instead. For a default value of
     * {@code null}, use {@link #orNull}.
     */
    public abstract T or(T defaultValue);

    /**
     * Returns the contained value if it has a value present; {@code null}
     * otherwise.
     */
    public abstract T orNull();

    /**
     * Returns a {@link Set} whose only element is the contained instance if it
     * is present; an empty {@link Set} otherwise.
     * 
     */
    public abstract Set<T> asSet();

    /**
     * Returns {@code true} if this holder contains an exception
     */
    public abstract boolean hasException();

    /**
     * Returns the contained exception, if there is one (the value is absent).
     * 
     * @throws IllegalStateException
     *             if the value is present ({@link #isPresent} returns
     *             {@code true})
     */
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
