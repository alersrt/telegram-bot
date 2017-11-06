package com.instrumentisto.timebot.converter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link MessageDTOToTelegramSendMessageConverter}.
 */
public class MessageDTOToTelegramSendMessageConverterTest {

    /**
     * Object of testing class.
     */
    private MessageDTOToTelegramSendMessageConverter dtoConverter = new MessageDTOToTelegramSendMessageConverter();

    /**
     * Test for {@code convert()} method.
     *
     * Check assertion: returned SendMessage's object must be equal to gauge
     * object.
     */
    @Test
    public void convert() {
        MessageDTO messageDTO = mock(MessageDTO.class);
        when(messageDTO.getChatId()).thenReturn("0");
        when(messageDTO.getText()).thenReturn("test message");

        Assert.assertEquals(new SendMessage("0", "test message")
                .getParameters(),
            dtoConverter.convert(messageDTO)
                .getParameters());
    }
}
