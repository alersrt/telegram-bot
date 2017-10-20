package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ConverterUtil} for {@link Message}.
 */
@Component
public class TelegramMessageConverterUtil implements ConverterUtil<Message> {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseDTO toDTO(Message message) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", message.getText());
        baseDTO.addValueOfField("chatId", message.getChatId());
        baseDTO.addValueOfField("username", message.getUsername());
        return baseDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message fromDTO(BaseDTO baseDto) {
        Message message = new Message();
        message.setText(baseDto.getValueOfField("text").toString());
        message.setChatId(baseDto.getValueOfField("chatId").toString());
        message.setUsername(baseDto.getValueOfField("username").toString());
        return message;
    }
}
