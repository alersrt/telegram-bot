package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageQueryService}.
 */
@Service
public class TelegramMessageQueryTimeService implements MessageQueryService {

    /**
     * Format of DateTime which injects from properties.
     */
    @Value("${bot.datetime.format}")
    private String datetimeformat;

    /**
     * {@inheritDoc}
     */
    @Override
    public Message queryProcessor(Message message) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String datetime = localDateTime.format(DateTimeFormatter.ofPattern(datetimeformat));
        message.setText(datetime);
        return message;
    }
}
