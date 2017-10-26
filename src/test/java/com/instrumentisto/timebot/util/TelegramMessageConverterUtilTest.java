package com.instrumentisto.timebot.util;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import java.util.Arrays;
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
    public void testMessageToDTO() throws Exception {
        Message message = new Message();
        message.setText("test");
        message.setChatId("1L");
        message.setUsername("username");
        message.setLocation(new double[]{52.31, 85.10});
        message.setTimezoneId("Asia/Krasnoyarsk");

        BaseDTO baseDTO = converterUtil.toDTO(message);

        Assert.assertNotNull(baseDTO);
        Assert.assertEquals(baseDTO.getValueOfField("text"), message.getText());
        Assert.assertEquals(baseDTO.getValueOfField("chatId"),
            message.getChatId());
        Assert.assertEquals(message.getUsername(),
            baseDTO.getValueOfField("username"));
        Assert.assertTrue(Arrays.equals(message.getLocation(),
            new double[]{(Double) baseDTO.getValueOfField("latitude"),
                (Double) baseDTO.getValueOfField("longitude")}));
    }

    /**
     * Test for {@code fromDTO()} method.
     *
     * Checks assertions:
     * 1. Returned {@link Message} must not be null;
     * 2. Fields of {@link Message} must be equals to fields of {@link BaseDTO}.
     */
    @Test
    public void testMessageFromDTO() throws Exception {
        Message message1 = new Message();
        message1.setText("test");
        message1.setChatId("1L");
        message1.setUsername("username");

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", "1L");
        baseDTO.addValueOfField("username", "username");
        baseDTO.addValueOfField("latitude", 51.28);
        baseDTO.addValueOfField("longitude", 0.00);
        baseDTO.addValueOfField("timezoneId", "Europe/London");
        Message message2 = converterUtil.fromDTO(baseDTO);

        Assert.assertNotNull(message2);
        Assert.assertEquals(message1, message2);
    }
}
