package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;

/**
 * Handler for input request.
 */
public interface RequestHandler {

    /**
     * Processes of input request.
     *
     * @param baseDTO DTO for object which received from API.
     */
    void handleRequest(BaseDTO baseDTO);
}
