package com.instrumentisto.timebot.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.pengrad.telegrambot.model.Location;
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
     * 1. Returned {@link BaseDTO} must not be {@code null}.
     * 2. Stored fields of returned {@link BaseDTO} must be equals to field of
     * original {@link Update}.
     * 3. Stored text field for nullable message test must be equals to "".
     * 4. Stored username field for message which contained nullable user must be
     * equals to "user which has no username".
     * 5. Stored location fields for nullable location must to have such values
     * [latitude=51.28, longitude=0.0].
     */
    @Test
    public void testUpdateToDTO() throws Exception {
        Update update = mock(Update.class);
        Message message = mock(Message.class);
        User user = mock(User.class);
        Location location = mock(Location.class);

        when(user.id()).thenReturn(1);
        when(user.username()).thenReturn("username");
        when(location.latitude()).thenReturn(new Float(52.31));
        when(location.longitude()).thenReturn(new Float(85.10));
        when(message.text()).thenReturn("test");
        when(message.from()).thenReturn(user);
        when(message.location()).thenReturn(location);
        when(update.message()).thenReturn(message);

        BaseDTO baseDTO = converterUtil.toDTO(update);

        Assert.assertNotNull(baseDTO);
        Assert.assertEquals("test", baseDTO.getValueOfField("text"));
        Assert.assertEquals(1, baseDTO.getValueOfField("chatId"));
        Assert.assertEquals("username", baseDTO.getValueOfField("username"));
        Assert.assertTrue(
            Math.abs(52.31 - (Double) baseDTO.getValueOfField("latitude"))
                <= 0.001);
        Assert.assertTrue(
            Math.abs(85.10 - (Double) baseDTO.getValueOfField("longitude"))
                <= 0.001);

        when(message.text()).thenReturn(null);
        when(message.location()).thenReturn(null);
        when(user.username()).thenReturn(null);
        BaseDTO baseDTO1 = converterUtil.toDTO(update);
        Assert.assertEquals("user which has no username",
            baseDTO1.getValueOfField("username"));
        Assert.assertEquals("", baseDTO1.getValueOfField("text"));
        Assert.assertEquals(51.28, baseDTO1.getValueOfField("latitude"));
        Assert.assertEquals(0.0, baseDTO1.getValueOfField("longitude"));
    }

    /**
     * Test for {@code fromDTO()} method. Here is expects {@link
     * DTOConversionIsNotPossible}.
     */
    @Test(expected = DTOConversionIsNotPossible.class)
    public void testUpdateFromDTO() throws Exception {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.addValueOfField("text", "test");
        baseDTO.addValueOfField("chatId", 1);
        converterUtil.fromDTO(baseDTO);
    }
}
