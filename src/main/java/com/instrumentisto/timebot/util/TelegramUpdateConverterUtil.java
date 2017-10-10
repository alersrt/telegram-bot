package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ConverterUtil} for {@link Update}.
 */
@Component
public class TelegramUpdateConverterUtil implements ConverterUtil<Update> {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseDTO toDTO(Update update) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", update.message().text());
        baseDTO.addValueOfField("chatId", update.message().from().id());
        return baseDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update fromDTO(BaseDTO baseDto) throws DTOConversionIsNotPossible {
        throw new DTOConversionIsNotPossible();
    }
}
