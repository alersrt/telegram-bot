package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageQueryService} for any messages except command
 * which determined.
 */
@Service
public class TelegramMessageQueryDefaultService implements MessageQueryService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Message queryProcessor(Message message) {
        message.setText("The command was not recognized!");
        return message;
    }
}
