package com.instrumentisto.timebot.converter;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.DTO.UserDTO;
import com.pengrad.telegrambot.model.Location;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.User;
import java.util.Optional;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Converter from {@link Message} to {@link MessageDTO}.
 */
@Component
@ConfigurationPropertiesBinding
public class TelegramMessageToMessageDTOConverter implements
    Converter<Message, MessageDTO> {

    /**
     * Default username.
     */
    @Autowired
    @Qualifier("getDefaultUsername")
    private String defaultUsername;

    /**
     * Default latitude.
     */
    @Autowired
    @Qualifier("getDefaultLatitude")
    private double defaultLatitude;

    /**
     * Default longitude.
     */
    @Autowired
    @Qualifier("getDefaultLongitude")
    private double defaultLongitude;

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public MessageDTO convert(Message source) {
        Optional<User> user = Optional.ofNullable(source.from());
        Optional<Location> location = Optional.ofNullable(source.location());
        Optional<String> text = Optional.ofNullable(source.text());

        UserDTO userDTO = new UserDTO();
        userDTO.setApiId(user.orElse(getDefaultUser()).id().toString());
        userDTO.setUsername(user.orElse(getDefaultUser()).username());
        userDTO.setLatitude((double) location.orElse(getDefaultLocation()).latitude());
        userDTO.setLongitude((double) location.orElse(getDefaultLocation()).longitude());

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setUserDTO(userDTO);
        messageDTO.setChatId(user.orElse(getDefaultUser()).id().toString());
        messageDTO.setText(text.orElse(""));
        messageDTO.setLocationDefault(!location.isPresent());

        return messageDTO;
    }

    /**
     * Gets default {@link User} object.
     *
     * @return {@link User} object.
     */
    private User getDefaultUser() {
        User user = new User();

        try {
            FieldUtils.writeDeclaredField(user, "id", 0, true);
            FieldUtils.writeDeclaredField(user,
                "username", defaultUsername, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Gets default {@link Location} object.
     *
     * @return {@link Location} object.
     */
    private Location getDefaultLocation() {
        Location location = new Location();

        try {
            FieldUtils.writeDeclaredField(location, "latitude",
                (float) defaultLatitude,
                true);
            FieldUtils.writeDeclaredField(location, "longitude",
                (float) defaultLongitude,
                true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return location;
    }
}
