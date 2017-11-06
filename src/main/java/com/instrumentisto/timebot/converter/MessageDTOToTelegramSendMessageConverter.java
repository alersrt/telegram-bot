package com.instrumentisto.timebot.converter;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Converter from {@link MessageDTO} to {@link SendMessage}.
 */
@Component
@ConfigurationPropertiesBinding
public class MessageDTOToTelegramSendMessageConverter implements
    Converter<MessageDTO, SendMessage> {

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public SendMessage convert(MessageDTO source) {
        return new SendMessage(source.getChatId(), source.getText());
    }
}
