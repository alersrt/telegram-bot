package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ConverterUtil} for {@link SendMessage}.
 */
@Component
public class TelegramSendMessageConverterUtil implements
    ConverterUtil<SendMessage> {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseDTO toDTO(SendMessage sendMessage) {
        throw new DTOConversionIsNotPossible();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendMessage fromDTO(BaseDTO baseDto) {
        return new SendMessage(
            baseDto.getValueOfField("chatId"),
            (String) baseDto.getValueOfField("text"));
    }
}
