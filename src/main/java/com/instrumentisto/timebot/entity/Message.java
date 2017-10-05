package com.instrumentisto.timebot.entity;

/**
 * The class describes entity which presents bot's message.
 */
public class Message {

    /**
     * ID field which will used for work with database.
     */
    private int id;

    /**
     * Text field which contains text of message.
     */
    private String text;

    /**
     * Field which contains ID of recipient.
     */
    private String chatId;

    /**
     * Gets value of {@code id} field.
     *
     * @return {@link long} value.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets {@code id} field.
     *
     * @param id is value to which need to set {@code id} field.
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
     * @param text is value to which need to set {@code text} field.
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
     * @param chatId is value to which need to set {@code chatId} field.
     */
    public void setChatId(String chatId) {
        this.chatId = chatId;
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

        return id == message.id && (text != null ? text.equals(message.text) : message.text == null)
            && (chatId != null ? chatId.equals(message.chatId) : message.chatId == null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (chatId != null ? chatId.hashCode() : 0);
        return result;
    }
}
