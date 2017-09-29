package com.instrumentisto.timebot.entity;

/**
 * It is a basic message interface which describes basic behavior of this entity.
 */
public interface Message {

    /**
     * This method is returning value of message's text field.
     *
     * @return {@link String} value.
     */
    String getText();

    /**
     * This method sets a text field of message.
     *
     * @param text is value in which you need to set message's text field.
     */
    void setText(String text);

    /**
     * This method returns value of chatId field.
     *
     * @return {@link String} value.
     */
    String getChatId();

    /**
     * This method sets a chatId field of message.
     *
     * @param chatId is vule in which you need to set chatId field.
     */
    void setChatId(String chatId);
}
