package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryMessageDoesNotExist;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositorySaveException;
import java.util.List;

/**
 * Describes transfer of {@link Message} object between service and repository
 * layers.
 */
public interface MessageTransferService {

    /**
     * Saves input message into repository.
     *
     * @param message object of {@link Message}.
     * @throws InMemoryRepositorySaveException commits when something wrong with
     * process of saving in to repository.
     */
    void saveMessage(Message message) throws InMemoryRepositorySaveException;

    /**
     * Returns {@link Message} object from repository.
     *
     * @param id value of ID message which need to get.
     * @return {@link Message} value.
     * @throws InMemoryRepositoryMessageDoesNotExist commits during trying of
     * getting nonexistent {@link Message} from repository.
     */
    Message findById(int id) throws InMemoryRepositoryMessageDoesNotExist;

    /**
     * Returns list of all {@link Message} objects from repository.
     *
     * @return {@link List} of {@link Message}.
     */
    List<Message> getMessages();

    /**
     * Clear repository.
     */
    void clearRepository();
}
