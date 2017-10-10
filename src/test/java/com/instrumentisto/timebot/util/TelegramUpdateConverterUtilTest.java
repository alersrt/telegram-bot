package com.instrumentisto.timebot.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramUpdateConverterUtil}.
 */
public class TelegramUpdateConverterUtilTest {

    private TelegramUpdateConverterUtil converterUtil;

    /**
     * Start boundaries for the test.
     */
    @Before
    public void setUp() throws Exception {
        converterUtil = new TelegramUpdateConverterUtil();
    }

    /**
     * Test for {@code toDTO()} method.
     *
     * Checks assertions:
     * 1. Returned {@link BaseDTO} must not be {@code null};
     * 2. Stored fields of returned {@link BaseDTO} must be equals to field of
     * original {@link Update}.
     */
    @Test
    public void testUpdateToDTO() throws Exception {
        Update update = mock(Update.class);
        Message message = mock(Message.class);
        User user = mock(User.class);
        when(user.id()).thenReturn(1);
        when(message.text()).thenReturn("test");
        when(message.from()).thenReturn(user);
        when(update.message()).thenReturn(message);

        BaseDTO baseDTO = converterUtil.toDTO(update);

        Assert.assertNotNull(baseDTO);
        Assert.assertEquals(baseDTO.getValueOfField("text"), "test");
        Assert.assertEquals(baseDTO.getValueOfField("chatId"), 1);
    }

    /**
     * Test for {@code fromDTO()} method. Here is expects {@link
     * DTOConversionIsNotPossible}.
     */
    @Test(expected = DTOConversionIsNotPossible.class)
    public void testUpdateFromDTO()
        throws Exception, DTOConversionIsNotPossible {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", 1);
        Update update2 = converterUtil.fromDTO(baseDTO);
    }
}
