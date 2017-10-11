package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryMessageDoesNotExist;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositorySaveException;
import com.instrumentisto.timebot.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageTransferService}.
 */
@Service
public class TelegramMessageTransferService implements MessageTransferService {

    @Autowired
    MessageRepository messageRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveMessage(Message message)
        throws InMemoryRepositorySaveException {
        messageRepository.saveMessage(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message findById(int id)
        throws InMemoryRepositoryMessageDoesNotExist {
        return messageRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Message> getMessages() {
        return messageRepository.getAllMessages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearRepository() {
        messageRepository.removeAll();
    }
}
