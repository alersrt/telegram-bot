package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;
import java.util.List;

/**
 * Handler for output response.
 */
public interface ResponseHandler {

    /**
     * Returns list of outputs answers to requests for bot.
     *
     * @return {@link List} of {@link BaseDTO}.
     */
    List<BaseDTO> handleResponse();
}
