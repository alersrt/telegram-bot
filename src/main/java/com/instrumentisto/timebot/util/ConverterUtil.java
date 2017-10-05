package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTOException;

/**
 * Util class which converts object to|from BaseDTO.
 *
 * @param <T> class to|from which commit converting.
 */
public interface ConverterUtil<T> {

    /**
     * Converts {@link T} to {@link BaseDTO}.
     *
     * @param t is object which need to convert.
     * @return {@link BaseDTO} value.
     */
    BaseDTO toDTO(T t) throws DTOException;

    /**
     * Converts {@link BaseDTO} to {@link T}.
     *
     * @param baseDto is BaseDTO which need to convert.
     * @return {@link T} value.
     */
    T fromDTO(BaseDTO baseDto) throws DTOException;

}
