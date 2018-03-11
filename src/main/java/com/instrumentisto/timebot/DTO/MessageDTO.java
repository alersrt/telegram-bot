package com.instrumentisto.timebot.DTO;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

/**
 * Describes DTO of {@link com.instrumentisto.timebot.entity.Message}
 */
@Data
@Component
public class MessageDTO {

    /**
     * Field which contains ID of receiving chat.
     */
    private String chatId;

    /**
     * Text field which contains text of message.
     */
    private String text;

    /**
     * Field which contains User's DTO.
     */
    private UserDTO userDTO;

    /**
     * Field which points to which state the location had.
     */
    private boolean isLocationDefault;
}
