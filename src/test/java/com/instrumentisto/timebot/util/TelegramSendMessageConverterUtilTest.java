package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTOException;
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
     * Test for {@code toDTO()} method.
     */
    @Test(expected = DTOException.class)
    public void testSendMessageToDTO() throws Exception, DTOException {
        SendMessage sendMessage = new SendMessage(1, "test");

        BaseDTO baseDTO = converterUtil.toDTO(sendMessage);
    }

    /**
     * Test for {@code fromDTO()} method.
     */
    @Test
    public void testSendMessageFromDTO() throws Exception, DTOException {
        SendMessage sendMessage1 = new SendMessage(1, "test");

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", 1);

        SendMessage sendMessage2 = converterUtil.fromDTO(baseDTO);

        Assert.assertNotNull(sendMessage2);

        /* TODO: There is no comparing
         * We can't to compare two SendMessage object because
         * there was not realize equals() and hashCode() methods.
         */
        Assert.assertEquals(sendMessage1, sendMessage2);
    }

}
