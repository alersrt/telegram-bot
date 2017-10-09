package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOException;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ConverterUtil} for {@link SendMessage}.
 */
@Component
public class TelegramSendMessageConverterUtil implements ConverterUtil<SendMessage> {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseDTO toDTO(SendMessage sendMessage) throws DTOException {
        throw new DTOException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendMessage fromDTO(BaseDTO baseDto) throws DTOException {
        SendMessage sendMessage = new SendMessage(baseDto.getValueOfField("chatId"),
            (String) baseDto.getValueOfField("text"));
        return sendMessage;
    }
}
