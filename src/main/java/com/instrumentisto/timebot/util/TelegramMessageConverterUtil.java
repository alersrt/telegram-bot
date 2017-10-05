package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.DTOException;

/**
 * Class-implementation of {@link ConverterUtil} for {@link Message}.
 */
public class TelegramMessageConverterUtil implements ConverterUtil<Message> {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseDTO toDTO(Message message) throws DTOException {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", message.getText());
        baseDTO.addValueOfField("chatId", message.getChatId());
        return baseDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message fromDTO(BaseDTO baseDto) throws DTOException {
        Message message = new Message();
        message.setText(baseDto.getValueOfField("text"));
        message.setChatId(baseDto.getValueOfField("chatId"));
        return message;
    }
}
