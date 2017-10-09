package com.instrumentisto.timebot.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link Message}.
 */
public class MessageTest {

    /**
     * Test getter and setter for {@code id} field.
     */
    @Test
    public void testGetAndSetForId() throws Exception {
        Message message = new Message();

        Assert.assertEquals(0, message.getId());

        message.setId(1);

        Assert.assertEquals(1, message.getId());
    }

    /**
     * Test getter and setter for {@code text} field.
     */
    @Test
    public void testGetAndSetForText() throws Exception {
        Message message = new Message();

        Assert.assertNull(message.getText());

        message.setText("test");

        Assert.assertEquals("test", message.getText());
    }

    /**
     * Test getter and setter for {@code chatId} field.
     */
    @Test
    public void testGetAndSetForChatId() throws Exception {
        Message message = new Message();

        Assert.assertNull(message.getChatId());

        message.setChatId("1L");

        Assert.assertEquals("1L", message.getChatId());
    }

    /**
     * Test for {@code equals()} and {@code hashCode()} methods.
     */
    @Test
    public void testEqualsAndHashCode() {
        Message message1 = new Message();
        Message message2 = new Message();

        Assert.assertTrue("Test equals() for clear objects",
            message1.equals(message2) && message2.equals(message1));
        Assert.assertTrue("Test hashCode() for clear objects",
            message1.hashCode() == message2.hashCode());

        message1.setId(1);
        message1.setText("The same message");
        message1.setChatId("1L");

        message2.setId(1);
        message2.setText("The same message");
        message2.setChatId("1L");

        Assert.assertTrue("Test equals() for identical objects",
            message1.equals(message2) && message2.equals(message1));
        Assert.assertTrue("Test hashCode() for identical objects",
            message1.hashCode() == message2.hashCode());

        message2.setId(2);
        message2.setText("Another message");
        message2.setChatId("2L");

        Assert.assertFalse("Test equals() for different objects",
            message1.equals(message2) && message2.equals(message1));
        Assert.assertFalse("Test hashCode() for different objects",
            message1.hashCode() == message2.hashCode());

        Assert.assertFalse("Test equals() for null", message1.equals(null));
        Assert.assertTrue("Test equals() for the same object", message1.equals(message1));
    }
}
