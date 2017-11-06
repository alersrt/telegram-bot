package com.instrumentisto.timebot.handler;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.repository.MessageRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

/**
 * Unit-test for {@link TelegramResponseHandler}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramResponseHandlerTest {

    /**
     * Mock for {@link ConversionService}.
     */
    @Mock
    private ConversionService converter;

    /**
     * Mock for {@link MessageRepository}.
     */
    @Mock
    private MessageRepository messageRepository;

    /**
     * Object of testing class.
     */
    @InjectMocks
    private ResponseHandler responseHandler = new TelegramResponseHandler();

    /**
     * Test for handleResponse() method.
     *
     * Check assertion: after handle messageList must be empty and messageDTOList
     * must contains 2 elements.
     */
    @Test
    public void handleResponse() {
        List<Message> messageList = new ArrayList<>();
        List<MessageDTO> messageDTOList = new ArrayList<>();

        Message message1 = mock(Message.class);
        Message message2 = mock(Message.class);

        messageList.add(message1);
        messageList.add(message2);

        MessageDTO messageDTO1 = mock(MessageDTO.class);
        MessageDTO messageDTO2 = mock(MessageDTO.class);

        when(converter.convert(message1, MessageDTO.class))
            .thenReturn(messageDTO1);
        when(converter.convert(message2, MessageDTO.class))
            .thenReturn(messageDTO2);

        when(messageRepository.findAll()).thenReturn(messageList);

        doAnswer(invocation -> {
            messageList.clear();
            return 0;
        }).when(messageRepository).deleteAll();

        messageDTOList = responseHandler.handleResponse();

        Assert.assertTrue(messageList.isEmpty() && messageDTOList.size() == 2);
    }

}
