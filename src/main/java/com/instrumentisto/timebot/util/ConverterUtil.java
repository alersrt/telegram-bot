package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.instrumentisto.timebot.exception.DTO.DTOFieldDoesNotExist;

/**
 * Describes classes which converts object to|from {@link BaseDTO}.
 *
 * @param <T> class to|from which commit converting.
 */
public interface ConverterUtil<T> {

    /**
     * Converts {@link T} to {@link BaseDTO}.
     *
     * @param t object which need to convert.
     * @return {@link BaseDTO} value.
     * @throws DTOConversionIsNotPossible commits when converting is not possible.
     */
    BaseDTO toDTO(T t) throws DTOConversionIsNotPossible;

    /**
     * Converts {@link BaseDTO} to {@link T}.
     *
     * @param baseDto BaseDTO which need to convert.
     * @return {@link T} value.
     * @throws DTOConversionIsNotPossible commits when converting is not possible.
     * @throws DTOFieldDoesNotExist commits when something tries to get
     * nonexistent field.
     */
    T fromDTO(BaseDTO baseDto)
        throws DTOConversionIsNotPossible, DTOFieldDoesNotExist;
}
