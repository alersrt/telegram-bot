package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;

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
     */
    BaseDTO toDTO(T t);

    /**
     * Converts {@link BaseDTO} to {@link T}.
     *
     * @param baseDto BaseDTO which need to convert.
     * @return {@link T} value.
     */
    T fromDTO(BaseDTO baseDto);
}
