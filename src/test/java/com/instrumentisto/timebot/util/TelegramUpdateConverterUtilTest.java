package com.instrumentisto.timebot.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTOException;
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
        Assert.assertEquals(Integer.parseInt(baseDTO.getValueOfField("chatId")), 1);
    }

    /**
     * Test for {@code fromDTO()} method.
     */
    @Test(expected = DTOException.class)
    public void testUpdateFromDTO() throws Exception, DTOException {
        Update update1 = mock(Update.class);
        Message message = mock(Message.class);
        User user = mock(User.class);
        when(user.id()).thenReturn(1);
        when(message.text()).thenReturn("test");
        when(message.from()).thenReturn(user);
        when(update1.message()).thenReturn(message);

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", "1L");
        Update update2 = converterUtil.fromDTO(baseDTO);

        Assert.assertNotNull(update2);
        Assert.assertEquals(update1, update2);
    }

}
