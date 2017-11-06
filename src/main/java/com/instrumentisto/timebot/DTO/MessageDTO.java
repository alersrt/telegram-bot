package com.instrumentisto.timebot.DTO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

/**
 * Describes DTO of {@link com.instrumentisto.timebot.entity.Message}
 */
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

    /**
     * Gets value of {@code chatId} field.
     *
     * @return {@link String} value.
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * Sets {@code chatId} field.
     *
     * @param chatId value to which need to set {@code chatId} field.
     */
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    /**
     * Gets value of {@code text} field.
     *
     * @return {@link String} value.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets {@code text} field.
     *
     * @param text value to which need to set {@code text} field.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets user from {@code userDTO} field.
     *
     * @return {@link UserDTO} object.
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Sets {@code userDTO} field.
     *
     * @param userDTO {@link UserDTO} object which need set as field of message.
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    /**
     * Gets state of {@code isLocationDefault} variable.
     *
     * @return boolean value.
     */
    public boolean isLocationDefault() {
        return isLocationDefault;
    }

    /**
     * Sets state of {@code isLocationDefault} variable.
     *
     * @param locationDefault state to which need to set {@code isLocationDefault}
     * variable.
     */
    public void setLocationDefault(boolean locationDefault) {
        isLocationDefault = locationDefault;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MessageDTO that = (MessageDTO) o;

        return new EqualsBuilder()
            .append(chatId, that.chatId)
            .append(text, that.text)
            .append(userDTO, that.userDTO)
            .append(isLocationDefault, that.isLocationDefault)
            .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(chatId)
            .append(text)
            .append(userDTO)
            .append(isLocationDefault)
            .toHashCode();
    }
}
