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

        String updateMessageText =
            update.message().text() != null ? update.message().text() : "";

        baseDTO.addValueOfField("text", updateMessageText);
        baseDTO.addValueOfField("chatId", update.message().from().id());
        baseDTO.addValueOfField("username",
            update.message().from().username() != null ? update.message()
                .from().username() : "user which has no username");
        return baseDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update fromDTO(BaseDTO baseDto) {
        throw new DTOConversionIsNotPossible();
    }
}
