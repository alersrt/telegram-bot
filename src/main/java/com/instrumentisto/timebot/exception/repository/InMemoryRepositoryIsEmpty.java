package com.instrumentisto.timebot.exception.repository;

/**
 * Inheritor of {@link RuntimeException}. This exception causes when we try to get
 * messages from empty repository.
 */
public class InMemoryRepositoryIsEmpty extends RuntimeException {
    //  At our case realization of this class is not necessary.
}
