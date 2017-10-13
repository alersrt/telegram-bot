package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageQueryService} for {@code "/start"} command.
 */
@Service
public class TelegramMessageQueryStartService implements MessageQueryService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Message queryProcessor(Message message) {
        message.setText(String.format("Hello, %s!", message.getUsername()));
        return message;
    }
}
