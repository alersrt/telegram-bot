package com.instrumentisto.timebot.converter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.DTO.UserDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.entity.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link MessageDTOToMessageConverter}.
 */
public class MessageDTOToMessageConverterTest {

    /**
     * Object of testing class.
     */
    private MessageDTOToMessageConverter dtoConverter = new MessageDTOToMessageConverter();

    /**
     * Test for {@code convert()} method.
     */
    @Test
    public void convert() {
        MessageDTO messageDTO = mock(MessageDTO.class);
        UserDTO userDTO = mock(UserDTO.class);

        when(userDTO.getApiId()).thenReturn("0");
        when(userDTO.getUsername()).thenReturn("tester");
        when(userDTO.getLatitude()).thenReturn(51.28);
        when(userDTO.getLongitude()).thenReturn(0.0);

        when(messageDTO.getChatId()).thenReturn("0");
        when(messageDTO.getText()).thenReturn("test message");
        when(messageDTO.getUserDTO()).thenReturn(userDTO);

        Message message = new Message();
        User user = new User();

        user.setApiId("0");
        user.setUsername("tester");
        user.setLatitude(51.28);
        user.setLongitude(0.0);

        message.setChatId("0");
        message.setText("test message");
        message.setUser(user);

        Assert.assertEquals(message, dtoConverter.convert(messageDTO));
    }
}
