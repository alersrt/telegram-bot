package com.instrumentisto.timebot.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link Message}.
 */
public class MessageTest {

    /**
     * Test getter and setter for {@code id} field of {@link Message}.
     *
     * Checks assertions:
     * 1. Id of new {@link Message} must be equals to 0;
     * 2. Returned value for message which have id equals to 1, must be equals
     * to 1.
     */
    @Test
    public void testGetAndSetForId() throws Exception {
        Message message = new Message();

        Assert.assertEquals(0, message.getId());

        message.setId(1);

        Assert.assertEquals(1, message.getId());
    }

    /**
     * Test getter and setter for {@code text} field of {@link Message}.
     *
     * Checks assertions:
     * 1. {@code text} field of new message must be equals to {@code null};
     * 2. Returned value for message which have {@code text} field equals to
     * {@code "test"}, must be equals to {@code "test"}.
     */
    @Test
    public void testGetAndSetForText() throws Exception {
        Message message = new Message();

        Assert.assertNull(message.getText());

        message.setText("test");

        Assert.assertEquals("test", message.getText());
    }

    /**
     * Test getter and setter for {@code chatId} field of {@link Message}.
     *
     * Checks assertions:
     * 1. {@code chatId} field of new object must be {@code null};
     * 2. Returned value for message which have {@code chatId} field equals to
     * {@code "1L"}, must be equals to {@code "1L"}.
     */
    @Test
    public void testGetAndSetForChatId() throws Exception {
        Message message = new Message();

        Assert.assertNull(message.getChatId());

        message.setChatId("1L");

        Assert.assertEquals("1L", message.getChatId());
    }

    /**
     * Test for {@code equals()} and {@code hashCode()} methods for {@link
     * Message}.
     *
     * Checks assertions:
     * 1. Clear objects must be equals;
     * 2. Hashcodes of clear objects must be equals;
     * 3. Identical objects must be equals;
     * 4. Hashcodes of identical objects must be equals;
     * 5. Different objects must not be equals;
     * 6. Hashcode of different objects must not be equals;
     * 7. Object must not be equals to {@code null};
     * 8. Object must be equals to itself.
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
        Assert.assertTrue("Test equals() for the same object",
            message1.equals(message1));
    }
}
