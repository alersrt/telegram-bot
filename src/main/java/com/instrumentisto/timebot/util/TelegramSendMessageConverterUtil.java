package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTOException;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Class-implementation of {@link ConverterUtil} for {@link SendMessage}.
 */
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
        return new SendMessage(
            baseDto.getValueOfField("chatId"), baseDto.getValueOfField("text")
        );
    }
}
