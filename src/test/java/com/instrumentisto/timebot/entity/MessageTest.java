package com.instrumentisto.timebot.entity;

import static org.mockito.Mockito.mock;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link Message}.
 */
public class MessageTest {

    /**
     * Object of testing class.
     */
    private Message message = new Message();

    /**
     * Test getter for {@code id} field.
     *
     * Check assertion: returned value must be equals to 2.
     */
    @Test
    public void getId() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(message, "id", 2, true);

        Assert.assertEquals(2, message.getId());
    }

    /**
     * Test setter for {@code id} field.
     *
     * Check assertion: value of {@code id} field must be equals to 4.
     */
    @Test
    public void setId() throws IllegalAccessException {
        message.setId(4);

        int idValue = (int) FieldUtils.readDeclaredField(message, "id", true);

        Assert.assertEquals(4, idValue);
    }

    /**
     * Test getter for {@code text} field.
     *
     * Check assertion: returned value must be equals to "test message".
     */
    @Test
    public void getText() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(message, "text", "test message", true);

        Assert.assertEquals("test message", message.getText());
    }

    /**
     * Test setter for {@code test} field.
     *
     * Check assertion: value of {@code text} field must be equals to "another
     * message".
     */
    @Test
    public void setText() throws IllegalAccessException {
        message.setText("another message");

        String textValue = (String) FieldUtils
            .readDeclaredField(message, "text", true);

        Assert.assertEquals("another message", textValue);
    }

    /**
     * Test getter for {@code chatId} field.
     *
     * Check assertion: returned value must be equals to "3".
     */
    @Test
    public void getChatId() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(message, "chatId", "3", true);

        Assert.assertEquals("3", message.getChatId());
    }

    /**
     * Test setter for {@code chatId} field.
     *
     * Check assertion: value of {@code chatId} field must be equals to "21".
     */
    @Test
    public void setChatId() throws IllegalAccessException {
        message.setChatId("21");

        String chatIdValue = (String) FieldUtils
            .readDeclaredField(message, "chatId", true);

        Assert.assertEquals("21", chatIdValue);
    }

    /**
     * Test getter for {@code user} field.
     *
     * Check assertion: returned object must be equals to gauge user.
     */
    @Test
    public void getUser() throws IllegalAccessException {
        User user = mock(User.class);

        FieldUtils.writeDeclaredField(message, "user", user, true);

        Assert.assertEquals(user, message.getUser());
    }

    /**
     * Test setter for {@code user} field.
     *
     * Check assertion: value of {@code user} field must be equals to gauge
     * object.
     */
    @Test
    public void setUser() throws IllegalAccessException {
        User user = mock(User.class);

        message.setUser(user);

        User userValue = (User) FieldUtils
            .readDeclaredField(message, "user", true);

        Assert.assertEquals(user, userValue);
    }

    /**
     * Test equals() method.
     *
     * Check assertion: object must be equals to himself.
     */
    @Test
    public void equals_same_returnTrue() {
        Assert.assertTrue(message.equals(message));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: object does not equals to object of another class.
     */
    @Test
    public void equals_anotherClass_returnFalse() {
        Assert.assertFalse(message.equals(new Object()));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: different objects do not equals.
     */
    @Test
    public void equals_different_returnFalse() {
        Message message1 = new Message();
        message1.setId(1);
        Message message2 = new Message();
        message2.setId(2);

        Assert.assertFalse(message1.equals(message2));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: identical objects must be equals.
     */
    @Test
    public void equals_identical_returnTrue() {
        Message message1 = new Message();
        message1.setText("test message");
        Message message2 = new Message();
        message2.setText("test message");

        Assert.assertTrue(message1.equals(message2));
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hash codes for the same objects must be equals.
     */
    @Test
    public void hashCode_same_returnTrue() {
        Assert.assertTrue(message.hashCode() == message.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hash codes for different objects do not equals.
     */
    @Test
    public void hashCode_different_returnFalse() {
        Message message1 = new Message();
        message1.setId(1);
        Message message2 = new Message();
        message2.setId(2);

        Assert.assertFalse(message1.hashCode() == message2.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hash codes for identical objects must be equals.
     */
    @Test
    public void hashCode_identical_returnTrue() {
        Message message1 = new Message();
        message1.setText("test message");
        Message message2 = new Message();
        message2.setText("test message");

        Assert.assertTrue(message1.hashCode() == message2.hashCode());
    }
}
