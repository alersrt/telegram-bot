package com.instrumentisto.timebot.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * It is Unit-test for {@link Message}.
 */
public class MessageTest {

    /**
     * Test for {@code id} field getter.
     */
    @Test
    public void getId() throws Exception {

    }

    /**
     * Test for {@code id} field setter.
     */
    @Test
    public void setId() throws Exception {
    }

    /**
     * Test for {@code text} field getter.
     */
    @Test
    public void getText() throws Exception {
    }

    /**
     * Test for {@code text} field setter.
     */
    @Test
    public void setText() throws Exception {
    }

    /**
     * Test for {@code chatId} field getter.
     */
    @Test
    public void getChatId() throws Exception {
    }

    /**
     * Test for {@code chatId} field setter.
     */
    @Test
    public void setChatId() throws Exception {
    }

    /**
     * Test for {@code equals()} and {@code hashCode()} methods.
     */
    @Test
    public void testEqualsHashCode() {
        Message message1 = new Message();
        Message message2 = new Message();

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

    }


}
