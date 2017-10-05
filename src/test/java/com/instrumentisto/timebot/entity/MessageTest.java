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
}
