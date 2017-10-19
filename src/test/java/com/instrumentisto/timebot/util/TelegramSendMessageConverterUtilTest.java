package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramSendMessageConverterUtil}.
 */
public class TelegramSendMessageConverterUtilTest {

    private TelegramSendMessageConverterUtil converterUtil;

    /**
     * Start boundaries for the test.
     */
    @Before
    public void setUp() throws Exception {
        converterUtil = new TelegramSendMessageConverterUtil();
    }

    /**
     * Test for {@code toDTO()} method. Here is expects {@link
     * DTOConversionIsNotPossible}.
     */
    @Test(expected = DTOConversionIsNotPossible.class)
    public void testSendMessageToDTO() throws Exception {
        SendMessage sendMessage = new SendMessage(1, "test");

        converterUtil.toDTO(sendMessage);
    }

    /**
     * Test for {@code fromDTO()} method.
     *
     * Checks assertions:
     * 1. Returned {@link SendMessage} must not be {@code null};
     * 2. Fields of restored {@link SendMessage} must be equals to fields of
     * {@link BaseDTO} from which we extract {@link SendMessage}.
     */
    @Test
    public void testSendMessageFromDTO() throws Exception {
        SendMessage sendMessage1 = new SendMessage(1, "test");

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", 1);

        SendMessage sendMessage2 = converterUtil.fromDTO(baseDTO);

        Assert.assertNotNull(sendMessage2);
        Assert.assertEquals(
            sendMessage1.getParameters(), sendMessage2.getParameters());
    }
}
