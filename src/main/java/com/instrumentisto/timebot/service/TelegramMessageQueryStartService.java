package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageQueryService} for {@code "/start"} command.
 */
@Service
public class TelegramMessageQueryStartService implements MessageQueryService {

    @Autowired
    @Qualifier("getStartMessage")
    private String startMessage;

    /**
     * {@inheritDoc}
     */
    @Override
    public Message queryProcessor(Message message) {
        message.setText(String.format("Hello, %s!\n" + startMessage,
            message.getUser().getUsername()));
        return message;
    }
}
