package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.MessageDTO;

/**
 * Handler for input request.
 */
public interface RequestHandler {

    /**
     * Processes of input request.
     *
     * @param messageDTO DTO for object which received from API.
     */
    void handleRequest(MessageDTO messageDTO);
}
