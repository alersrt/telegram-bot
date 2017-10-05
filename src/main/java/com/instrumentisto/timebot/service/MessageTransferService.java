package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

/**
 * This interface describes transfer of {@link Message} object between service and repository
 * layers.
 */
public interface MessageTransferService {

    /**
     * Saves input message into repository.
     *
     * @param message object of {@link Message}.
     */
    void saveMessage(Message message);

    /**
     * Returns {@link Message} object from repository.
     *
     * @param id value of ID message which need to get.
     * @return {@link Message} value.
     */
    Message findById(long id);

    /**
     * Returns list of all {@link Message} objects from repository.
     *
     * @return {@link List<Message>} collection.
     */
    List<Message> getMessages();

    /**
     * Clear repository.
     */
    void clearRepository();
}
