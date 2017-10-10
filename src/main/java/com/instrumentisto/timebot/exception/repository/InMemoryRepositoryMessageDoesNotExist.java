package com.instrumentisto.timebot.exception.repository;

/**
 * Inheritor of {@link Exception}. This exception causes when {@link
 * com.instrumentisto.timebot.entity.Message} which we try to get from
 * repository does not exist.
 */
public class InMemoryRepositoryMessageDoesNotExist extends Exception {
    //  At our case realization of this class is not necessary.
}
