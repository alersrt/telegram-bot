package com.instrumentisto.timebot.exception.lambda;

import java.util.function.Function;

/**
 * Inheritor of {@link Function}. Describes throwable {@link Function}.
 *
 * @param <T> the type of the input to the function.
 * @param <R> the type of the result of the function.
 * @param <E> exception which will throwing.
 */
@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Exception> extends
    Function<T, R> {

    /**
     * {@inheritDoc}
     */
    @Override
    default R apply(T t) {
        try {
            return applyThrows(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Declares a throws clause of type.
     *
     * @param t input element.
     * @return {@link T} value.
     * @throws E exception which will throwing.
     */
    R applyThrows(T t) throws E;
}
