package com.instrumentisto.timebot.repository.inmemory;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryMessageDoesNotExist;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositorySaveException;
import com.instrumentisto.timebot.repository.MessageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link MessageRepository}.
 */
@Component
public class InMemoryMessageRepository implements MessageRepository {

    /**
     * Sequencer for ID of message.
     */
    private int idSequencer;

    /**
     * Collection in which repository stored.
     */
    private List<Message> repository;

    /**
     * Getter for {@code idSequencer} field.
     *
     * @return {@link int} value.
     */
    public int getIdSequencer() {
        return idSequencer;
    }

    /**
     * Setter for {@code idSequencer} field.
     *
     * @param idSequencer value to which need to set {@code idSequencer} field.
     */
    public void setIdSequencer(int idSequencer) {
        this.idSequencer = idSequencer;
    }

    /**
     * Getter for {@code repository} field.
     *
     * @return {@link List} of {@link Message}.
     */
    public List<Message> getRepository() {
        return repository;
    }

    /**
     * Setter for {@code repository} field.
     *
     * @param repository value to which need to set {@code repository} field.
     */
    public void setRepository(List<Message> repository) {
        this.repository = repository;
    }

    /**
     * Constructor which initialize sequencer and repository.
     */
    public InMemoryMessageRepository() {
        idSequencer = 0;
        repository = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message findById(int id)
        throws InMemoryRepositoryMessageDoesNotExist {
        return repository.stream().filter(m -> m.getId() == id).findFirst()
            .orElseThrow(InMemoryRepositoryMessageDoesNotExist::new);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveMessage(Message message)
        throws InMemoryRepositorySaveException {
        message.setId(idSequencer++);
        repository.add(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Message> getAllMessages() {
        return repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAll() {
        repository.clear();
    }
}
