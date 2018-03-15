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
 * Unit-test for {@link MessageToMessageDTOConverter}.
 */
public class MessageToMessageDTOConverterTest {

    /**
     * Object of testing class.
     */
    private MessageToMessageDTOConverter dtoConverter = new MessageToMessageDTOConverter();

    /**
     * Test for {@code convert()} method.
     *
     * Check assertion: getting converted object must be equals to gauge object.
     */
    @Test
    public void convert() {
        Message message = mock(Message.class);
        User user = mock(User.class);

        when(user.getLatitude()).thenReturn(51.28);
        when(user.getLongitude()).thenReturn(0.0);
        when(user.getApiId()).thenReturn("0");
        when(user.getUsername()).thenReturn("tester");

        when(message.getUser()).thenReturn(user);
        when(message.getChatId()).thenReturn("0");
        when(message.getText()).thenReturn("test message");

        MessageDTO messageDTO = new MessageDTO();
        UserDTO userDTO = new UserDTO();

        userDTO.setApiId("0");
        userDTO.setUsername("tester");
        userDTO.setLatitude(51.28);
        userDTO.setLongitude(0.0);

        messageDTO.setChatId("0");
        messageDTO.setText("test message");
        messageDTO.setUserDTO(userDTO);

        Assert.assertEquals(messageDTO, dtoConverter.convert(message));
    }

}
