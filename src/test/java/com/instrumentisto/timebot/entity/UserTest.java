package com.instrumentisto.timebot.entity;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link User}.
 */
public class UserTest {

    private User user = new User();

    /**
     * Test getter for {@code id} field of {@link User}.
     *
     * Check assertion: returned value of id field must be equal to 4.
     */
    @Test
    public void getId() throws IllegalAccessException {
        FieldUtils.writeField(user, "id", 4, true);

        Assert.assertEquals(4, user.getId());
    }

    /**
     * Test setter for {@code id} field of {@link User}.
     *
     * Check assertion: value of id field must be equal to 5.
     */
    @Test
    public void setId() throws IllegalAccessException {
        user.setId(5);
        int idValue = (Integer) FieldUtils.readDeclaredField(user, "id", true);

        Assert.assertEquals(5, idValue);
    }

    /**
     * Test getter for {@code apiId} field of {@link User}.
     *
     * Check assertion: returned value of apiId field must be equal to "1L".
     */
    @Test
    public void getApiId() throws IllegalAccessException {
        FieldUtils.writeField(user, "apiId", "1L", true);

        Assert.assertEquals("1L", user.getApiId());
    }

    /**
     * Test setter for {@code apiId} field of {@link User}.
     *
     * Check assertion: value of apiId field must be equal to "2L".
     */
    @Test
    public void setApiId() throws IllegalAccessException {
        user.setApiId("2L");
        String apiIdValue = (String) FieldUtils
            .readDeclaredField(user, "apiId", true);

        Assert.assertEquals("2L", apiIdValue);
    }

    /**
     * Test getter for {@code username} field of {@link User}.
     *
     * Check assertion: returned value of username field must be equal to
     * "tester".
     */
    @Test
    public void getUsername() throws IllegalAccessException {
        FieldUtils.writeField(user, "username", "tester", true);

        Assert.assertEquals("tester", user.getUsername());
    }

    /**
     * Test setter for {@code username} field of {@link User}.
     *
     * Check assertion: returned value of username field must be equal to
     * "newtester".
     */
    @Test
    public void setUsername() throws IllegalAccessException {
        user.setUsername("newtester");
        String usernameValue = (String) FieldUtils
            .readDeclaredField(user, "username", true);

        Assert.assertEquals("newtester", usernameValue);
    }

    /**
     * Test getter for location of {@link User}.
     *
     * Check assertion: returned value of location must be equal to [52.31,
     * 85.10].
     *
     * Note: accuracy of comparing is 0.001
     */
    @Test
    public void getLocation() throws IllegalAccessException {
        FieldUtils.writeField(user, "latitude", 52.31, true);
        FieldUtils.writeField(user, "longitude", 85.10, true);

        Assert.assertEquals(52.31, user.getLocation()[0], 0.001);
        Assert.assertEquals(85.10, user.getLocation()[1], 0.001);
    }

    /**
     * Test setter for location of {@link User}.
     *
     * Check assertion: values of location must be equals to [51.28, 0.0].
     *
     * Note: accuracy of comparing is 0.001
     */
    @Test
    public void setLocation() throws IllegalAccessException {
        user.setLocation(51.28, 0.0);

        double latitudeValue = (double) FieldUtils
            .readDeclaredField(user, "latitude", true);
        double longitudeValue = (double) FieldUtils
            .readDeclaredField(user, "longitude", true);

        Assert.assertEquals(51.28, latitudeValue, 0.001);
        Assert.assertEquals(0.00, longitudeValue, 0.001);
    }

    /**
     * Test getter for {@code messages} field.
     *
     * Check assertion: returned messages list must be equals to gauge list.
     */
    @Test
    public void getMessages() throws IllegalAccessException {
        List<Message> messages = new ArrayList<>();
        Message message = mock(Message.class);
        messages.add(message);

        FieldUtils.writeDeclaredField(user, "messages", messages, true);

        Assert.assertEquals(messages, user.getMessages());
    }

    @Test
    public void setMessages() throws IllegalAccessException {
        List<Message> messages = new ArrayList<>();
        Message message = mock(Message.class);
        messages.add(message);

        user.setMessages(messages);

        List<Message> messagesValue = (List<Message>) FieldUtils
            .readDeclaredField(user, "messages", true);

        Assert.assertEquals(messages, messagesValue);
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link User} equals to himself.
     */
    @Test
    public void equals_same_returnTrue() {
        Assert.assertTrue(user.equals(user));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link User} does not equal to object of another class.
     */
    @Test
    public void equals_anotherClass_returnFalse() {
        Assert.assertFalse(user.equals(new Object()));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link User} objects with same apiId's are equals.
     */
    @Test
    public void equals_equalsFields_returnTrue() {
        User user1 = new User();
        User user2 = new User();

        user1.setApiId("1L");
        user2.setApiId("1L");

        Assert.assertTrue(user1.equals(user2));
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode of the same object is equal.
     */
    @Test
    public void hashCode_same_returnTrue() {
        User user = new User();
        user.setApiId("1L");

        Assert.assertTrue(user.hashCode() == user.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode's for equal apiId's are equal.
     */
    public void hashCode_equalsFields_returnTrue() {
        User user1 = new User();
        User user2 = new User();

        user1.setApiId("1L");
        user2.setApiId("1L");

        Assert.assertTrue(user1.hashCode() == user2.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode's for different apiId's are not equal.
     */
    public void hashCode_differentFields_returnFalse() {
        User user1 = new User();
        User user2 = new User();

        user1.setApiId("1L");
        user2.setApiId("2L");

        Assert.assertFalse(user1.hashCode() == user2.hashCode());
    }
}
