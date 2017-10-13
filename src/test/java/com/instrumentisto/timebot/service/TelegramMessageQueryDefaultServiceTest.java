package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramMessageQueryDefaultService}
 */
public class TelegramMessageQueryDefaultServiceTest {

    /**
     * Test for {@code queryProcessor(Message message)} method.
     *
     * Checks assertions:
     * 1. Output {@link Message} must not be null;
     * 2. Output message text must be equals to expected text.
     */
    @Test
    public void queryProcessor() throws Exception {
        TelegramMessageQueryDefaultService defaultService = new TelegramMessageQueryDefaultService();

        Message message = new Message();

        Message outMessage = defaultService.queryProcessor(message);

        Assert.assertNotNull(outMessage);
        Assert.assertEquals("The command was not recognized!",
            outMessage.getText());
    }

}
