package com.instrumentisto.timebot.repository;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

/**
 * Interface for messages' repository.
 */
public interface MessageRepository {

    /**
     * Searches {@link Message} in repository by ID.
     *
     * @param id id by which you need to find message.
     * @return {@link Message} value.
     */
    Message findById(long id);

    /**
     * Saves message in to repository.
     *
     * @param message message which you need to save in to repository.
     */
    void saveMessage(Message message);

    /**
     * Gets all messages from repository.
     *
     * @return {@link List} of {@link Message}.
     */
    List<Message> getAllMessages();

    /**
     * Remove all messages from repository.
     */
    void removeAll();
}
