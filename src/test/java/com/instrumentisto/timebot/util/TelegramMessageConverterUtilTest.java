package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.DTOException;
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
     * TODO: What expects?
     */
    @Test
    public void testMessageToDTO() throws Exception, DTOException {
        Message message = new Message();
        message.setText("test");
        message.setChatId("1L");

        BaseDTO baseDTO = converterUtil.toDTO(message);

        Assert.assertNotNull(baseDTO);
        Assert.assertEquals(baseDTO.getValueOfField("text"), message.getText());
        Assert.assertEquals(baseDTO.getValueOfField("chatId"), message.getChatId());
    }

    /**
     * Test for {@code fromDTO()} method.
     * TODO: What expects?
     */
    @Test
    public void testMessageFromDTO() throws Exception, DTOException {
        Message message1 = new Message();
        message1.setText("test");
        message1.setChatId("1L");

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", "1L");
        Message message2 = converterUtil.fromDTO(baseDTO);

        Assert.assertNotNull(message2);
        Assert.assertEquals(message1, message2);
    }

}
