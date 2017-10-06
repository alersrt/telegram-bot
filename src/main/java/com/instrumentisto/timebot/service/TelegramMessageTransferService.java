package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageTransferService}.
 */
@Service
public class TelegramMessageTransferService implements MessageTransferService {

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveMessage(Message message) {
        // TODO: Realize this method
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message findById(long id) {
        // TODO: Realize this method
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Message> getMessages() {
        // TODO: Realize this method
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearRepository() {
        // TODO: Realize this method
    }
}
