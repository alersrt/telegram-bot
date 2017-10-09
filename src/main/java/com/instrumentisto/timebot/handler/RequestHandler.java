package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOException;

/**
 * Handler for input request.
 */
public interface RequestHandler {

    /**
     * Processes of input request.
     *
     * @param baseDTO DTO for object which received from API.
     * @throws DTOException exception commits if any method of DTO converter
     * does not possible to execute.
     */
    void handleRequest(BaseDTO baseDTO) throws DTOException;
}
