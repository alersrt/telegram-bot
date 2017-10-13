package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramMessageConverterUtil}.
 */
public class TelegramMessageConverterUtilTest {

    private TelegramMessageConverterUtil converterUtil;

    /**
     * Start boundaries for the test.
     */
    @Before
    public void setUp() {
        converterUtil = new TelegramMessageConverterUtil();
    }

    /**
     * Test for {@code toDTO()} method.
     *
     * Checks assertions:
     * 1. Returned {@link BaseDTO} must not be null;
     * 2. Fields of {@link BaseDTO} must be equals to fields of {@link Message}.
     */
    @Test
    public void testMessageToDTO()
        throws Exception, DTOConversionIsNotPossible {
        Message message = new Message();
        message.setText("test");
        message.setChatId("1L");

        BaseDTO baseDTO = converterUtil.toDTO(message);

        Assert.assertNotNull(baseDTO);
        Assert.assertEquals(baseDTO.getValueOfField("text"), message.getText());
        Assert.assertEquals(baseDTO.getValueOfField("chatId"),
            message.getChatId());
    }

    /**
     * Test for {@code fromDTO()} method.
     *
     * Checks assertions:
     * 1. Returned {@link Message} must not be null;
     * 2. Fields of {@link Message} must be equals to fields of {@link BaseDTO}.
     */
    @Test
    public void testMessageFromDTO()
        throws Exception, DTOConversionIsNotPossible {
        Message message1 = new Message();
        message1.setText("test");
        message1.setChatId("1L");
        message1.setUsername("username");

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", "1L");
        baseDTO.addValueOfField("username", "username");
        Message message2 = converterUtil.fromDTO(baseDTO);

        Assert.assertNotNull(message2);
        Assert.assertEquals(message1, message2);
    }
}
