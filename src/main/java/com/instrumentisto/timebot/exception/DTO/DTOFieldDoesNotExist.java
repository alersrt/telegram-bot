package com.instrumentisto.timebot.exception.DTO;

/**
 * Inheritor of {@link RuntimeException}. This exception causes when we try to get
 * field of {@link com.instrumentisto.timebot.DTO.BaseDTO} which does not
 * exist.
 */
public class DTOFieldDoesNotExist extends RuntimeException {
    //  At our case realization of this class is not necessary.
}
