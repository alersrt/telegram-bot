package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryIsEmpty;
import java.util.List;

/**
 * Handler for output response.
 */
public interface ResponseHandler {

    /**
     * Returns list of outputs answers to requests for bot.
     *
     * @return {@link List} of {@link BaseDTO}.
     * @throws InMemoryRepositoryIsEmpty exception commits if there is trying to
     * getting of empty list from repository.
     */
    List<BaseDTO> handleResponse()
        throws InMemoryRepositoryIsEmpty;
}
