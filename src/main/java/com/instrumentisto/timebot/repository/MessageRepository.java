package com.instrumentisto.timebot.repository;

import com.instrumentisto.timebot.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for messages' repository.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Searches {@link Message} in repository by ID.
     *
     * @param id id by which you need to find message.
     * @return {@link Message} value.
     */
    Message findById(int id);
}
