package com.instrumentisto.timebot.converter;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.entity.User;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Converter from {@link MessageDTO} to {@link Message}
 */
@Component
@ConfigurationPropertiesBinding
public class MessageDTOToMessageConverter implements
    Converter<MessageDTO, Message> {

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public Message convert(MessageDTO source) {
        Message message = new Message();
        User user = new User();

        user.setApiId(source.getUserDTO().getApiId());
        user.setUsername(source.getUserDTO().getUsername());
        user.setLatitude(source.getUserDTO().getLatitude());
        user.setLongitude(source.getUserDTO().getLongitude());

        message.setChatId(source.getChatId());
        message.setText(source.getText());
        message.setUser(user);

        return message;
    }
}
