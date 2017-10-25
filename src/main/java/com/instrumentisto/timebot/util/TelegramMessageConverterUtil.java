package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.DTO.DTOFieldDoesNotExist;
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
        baseDTO.addValueOfField("latitude", message.getLocation()[0]);
        baseDTO.addValueOfField("longitude", message.getLocation()[1]);
        baseDTO.addValueOfField("timezoneId", message.getTimezoneId());
        return baseDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message fromDTO(BaseDTO baseDto) throws DTOFieldDoesNotExist {
        Message message = new Message();
        message.setText(baseDto.getValueOfField("text").toString());
        message.setChatId(baseDto.getValueOfField("chatId").toString());
        message.setUsername(baseDto.getValueOfField("username").toString());

        double[] location = {(Double) baseDto.getValueOfField("latitude"),
            (Double) baseDto.getValueOfField("longitude")};
        message.setLocation(location);

        message.setTimezoneId(baseDto.getValueOfField("timezoneId").toString());

        return message;
    }
}
