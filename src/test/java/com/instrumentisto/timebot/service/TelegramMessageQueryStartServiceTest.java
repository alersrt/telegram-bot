package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramMessageQueryStartService}.
 */
public class TelegramMessageQueryStartServiceTest {

    /**
     * Test for {@code queryProcessor(Message message)} method.
     *
     * Checks assertions:
     * 1. Output {@link Message} must not be null;
     * 2. Output message text must be equals to expected text.
     */
    @Test
    public void queryProcessor() throws Exception {
        TelegramMessageQueryStartService startService = new TelegramMessageQueryStartService();

        Message message = new Message();
        message.setText("t1");
        message.setUsername("username");

        Message outMessage = startService.queryProcessor(message);

        Assert.assertNotNull(outMessage);
        Assert.assertEquals("Hello, username!", outMessage.getText());
    }

}
