package com.instrumentisto.timebot.entity;

/**
 * It is a basic message interface which describes basic behavior of this entity.
 */
public interface Message {

    /**
     * Returns value of message's text field.
     *
     * @return {@link String} value.
     */
    String getText();

    /**
     * Sets a text field of message.
     *
     * @param text is value in which you need to set message's text field.
     */
    void setText(String text);

    /**
     * Returns value of chatId field.
     *
     * @return {@link String} value.
     */
    String getChatId();

    /**
     * Sets a chatId field of message.
     *
     * @param chatId is vule in which you need to set chatId field.
     */
    void setChatId(String chatId);
}
