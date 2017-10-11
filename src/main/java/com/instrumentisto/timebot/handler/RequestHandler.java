package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.instrumentisto.timebot.exception.DTO.DTOFieldDoesNotExist;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositorySaveException;

/**
 * Handler for input request.
 */
public interface RequestHandler {

    /**
     * Processes of input request.
     *
     * @param baseDTO DTO for object which received from API.
     * @throws DTOConversionIsNotPossible exception commits if any method of DTO
     * converter does not possible to execute.
     * @throws DTOFieldDoesNotExist exception commits if any field of DTO does not
     * possible to get.
     * @throws InMemoryRepositorySaveException exception commits if Repository
     * with which works {@link com.instrumentisto.timebot.service.MessageTransferService}
     * works, throws its exception.
     */
    void handleRequest(BaseDTO baseDTO) throws DTOConversionIsNotPossible,
        DTOFieldDoesNotExist, InMemoryRepositorySaveException;
}
