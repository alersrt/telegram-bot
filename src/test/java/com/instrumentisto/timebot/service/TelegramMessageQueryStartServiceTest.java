package com.instrumentisto.timebot.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.entity.User;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramMessageQueryStartService}.
 */
public class TelegramMessageQueryStartServiceTest {

    /**
     * Object of testing class.
     */
    private MessageQueryService queryService = new TelegramMessageQueryStartService();

    /**
     * Test for queryProcessor() method.
     *
     * Check assertion: text of returned message must be equals to "Hello,
     * tester!\nsomething text".
     */
    @Test
    public void queryProcessor() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(
            queryService, "startMessage", "something text", true);

        User user = mock(User.class);
        when(user.getUsername()).thenReturn("tester");
        Message message = spy(Message.class);
        message.setText("initial message");
        when(message.getUser()).thenReturn(user);

        Message returnedMessage = queryService.queryProcessor(message);

        Assert.assertEquals("Hello, tester!\nsomething text",
            returnedMessage.getText());
    }
}
