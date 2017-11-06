package com.instrumentisto.timebot.converter;

import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.DTO.UserDTO;
import com.pengrad.telegrambot.model.Location;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.User;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit test for {@link TelegramMessageToMessageDTOConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramMessageToMessageDTOConverterTest {

    /**
     * Mock of {@link com.pengrad.telegrambot.model.Message}.
     */
    @Mock
    private Message message;

    /**
     * Mock of {@link com.pengrad.telegrambot.model.User}.
     */
    @Mock
    private User user;

    /**
     * Mock of {@link com.pengrad.telegrambot.model.Location}.
     */
    @Mock
    private Location location;

    /**
     * Object of testing class.
     */
    private TelegramMessageToMessageDTOConverter dtoConverter = new TelegramMessageToMessageDTOConverter();

    /**
     * Preparing of the test.
     */
    @Before
    public void setUp() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(dtoConverter,
            "defaultUsername", "testinguser", true);
        FieldUtils.writeDeclaredField(dtoConverter,
            "defaultLatitude", 52.31, true);
        FieldUtils.writeDeclaredField(dtoConverter,
            "defaultLongitude", 85.10, true);

        when(user.username()).thenReturn("tester");
        when(user.id()).thenReturn(0);

        when(location.latitude()).thenReturn(51.28f);
        when(location.longitude()).thenReturn(0.0f);
    }

    /**
     * Test for {@code convert()} method.
     *
     * Check assertion: convertedMessageDTO must be equal to messageDTO.
     */
    @Test
    public void convert_MessageWithoutNullFields_returnTrue()
        throws IllegalAccessException {
        when(message.from()).thenReturn(user);
        when(message.location()).thenReturn(location);
        when(message.text()).thenReturn("test message");

        UserDTO userDTO = new UserDTO();
        userDTO.setApiId("0");
        userDTO.setUsername("tester");
        userDTO.setLatitude(51.28f);
        userDTO.setLongitude(0.0f);

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setChatId("0");
        messageDTO.setText("test message");
        messageDTO.setUserDTO(userDTO);
        messageDTO.setLocationDefault(false);

        MessageDTO convertedMessageDTO = dtoConverter.convert(message);

        Assert.assertEquals(messageDTO, convertedMessageDTO);
    }

    /**
     * Test for {@code convert()} method.
     *
     * Check assertion: convertedMessageDTO must be equal to messageDTO.
     */
    @Test
    public void convert_MessageWithNullFields_returnTrue() {
        when(message.from()).thenReturn(null);
        when(message.location()).thenReturn(null);
        when(message.text()).thenReturn(null);

        UserDTO userDTO = new UserDTO();
        userDTO.setApiId("0");
        userDTO.setUsername("testinguser");
        userDTO.setLatitude(52.31f);
        userDTO.setLongitude(85.10f);

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setChatId("0");
        messageDTO.setText("");
        messageDTO.setUserDTO(userDTO);
        messageDTO.setLocationDefault(true);

        MessageDTO convertedMessageDTO = dtoConverter.convert(message);

        Assert.assertEquals(messageDTO, convertedMessageDTO);
    }
}
