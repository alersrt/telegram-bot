package com.instrumentisto.timebot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Describes entity which presents bot's message.
 */
@Entity
public class Message {

    /**
     * ID field which will used for work with database.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Text field which contains text of message.
     */
    @NotNull
    private String text;

    /**
     * Field which contains ID of recipient.
     */
    @NotNull
    private String chatId;

    /**
     * Field which contains {@link User} to which this message belongs.
     */
    @NotNull
    @ManyToOne
    private User user;

    /**
     * Gets value of {@code id} field.
     *
     * @return {@link long} value.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets {@code id} field.
     *
     * @param id value to which need to set {@code id} field.
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets user from {@code user} field.
     *
     * @return {@link User} object.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets {@code user} field.
     *
     * @param user {@link User} object which need set as field of message.
     */
    public void setUser(User user) {
        this.user = user;
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

        Message message = (Message) o;

        return new EqualsBuilder()
            .append(id, message.id)
            .append(text, message.text)
            .append(chatId, message.chatId)
            .append(user, message.user)
            .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(text)
            .append(chatId)
            .append(user)
            .toHashCode();
    }
}
