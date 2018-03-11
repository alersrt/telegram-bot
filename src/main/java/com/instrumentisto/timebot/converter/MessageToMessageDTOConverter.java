package com.instrumentisto.timebot.converter;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.DTO.UserDTO;
import com.instrumentisto.timebot.entity.Message;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Converter from {@link Message} to {@link MessageDTO}.
 */
@Component
@ConfigurationPropertiesBinding
public class MessageToMessageDTOConverter implements
    Converter<Message, MessageDTO> {

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public MessageDTO convert(Message source) {
        MessageDTO messageDTO = new MessageDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setApiId(source.getUser().getApiId());
        userDTO.setUsername(source.getUser().getUsername());
        userDTO.setLatitude(source.getUser().getLatitude());
        userDTO.setLongitude(source.getUser().getLongitude());

        messageDTO.setChatId(source.getChatId());
        messageDTO.setText(source.getText());
        messageDTO.setUserDTO(userDTO);

        return messageDTO;
    }
}
