package com.instrumentisto.timebot.exception.DTO;

import com.instrumentisto.timebot.util.ConverterUtil;

/**
 * It is inheritor of {@link Exception}. Exception is caused if converting in
 * {@link ConverterUtil} does not possible.
 */
public class DTOConversionIsNotPossible extends Exception {
    //  At our cause it does not necessary to realize.
}
