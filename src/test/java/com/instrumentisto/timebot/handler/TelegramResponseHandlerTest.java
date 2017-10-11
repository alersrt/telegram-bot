package com.instrumentisto.timebot.handler;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryIsEmpty;
import com.instrumentisto.timebot.service.MessageTransferService;
import com.instrumentisto.timebot.util.ConverterUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit-test for {@link TelegramResponseHandler}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramResponseHandlerTest {

    /**
     * Mock of {@link MessageTransferService} as dependence for {@link
     * TelegramResponseHandler}.
     */
    @Mock
    private MessageTransferService messageTransferService;

    /**
     * Mock of {@link ConverterUtil} as dependence for {@link
     * TelegramResponseHandler}.
     */
    @Mock
    private ConverterUtil<Message> converterUtil;

    /**
     * Mock {@link ResponseHandler} which initialized of {@link
     * TelegramResponseHandler} and injects its dependencies.
     */
    @InjectMocks
    private ResponseHandler responseHandler = new TelegramResponseHandler();

    /**
     * Test for {@code handleResponse()}.
     *
     * Checks assertions:
     * 1. List of message in repository must be empty;
     * 2. Returned list of DTO must not be null;
     * 3. Returned list of DTO must not be empty
     * 4. Text field of DTO must be equal to text field of original message;
     * 5. If we try to get empty list from repo then must cased {@link
     * InMemoryRepositoryIsEmpty}.
     */
    @Test
    public void handleResponse() throws Exception {
        List<Message> messages = new ArrayList<>();

        Message message = mock(Message.class);
        when(message.getText()).thenReturn("datetime");

        BaseDTO baseDTO = mock(BaseDTO.class);
        when(baseDTO.getValueOfField("text")).thenReturn("datetime");

        messages.add(message);

        when(converterUtil.toDTO(message)).thenReturn(baseDTO);

        doAnswer(invocation -> {
            messages.clear();
            return messages;
        }).when(messageTransferService).clearRepository();

        doAnswer(invocation -> {
            return messages;
        }).when(messageTransferService).getMessages();

        List<BaseDTO> retrievedList = responseHandler.handleResponse();

        Assert.assertTrue(messages.isEmpty());
        Assert.assertNotNull(retrievedList);
        Assert.assertTrue(!retrievedList.isEmpty());
        Assert.assertEquals(message.getText(),
            retrievedList.get(0).getValueOfField("text"));

        try {
            responseHandler.handleResponse();
        } catch (InMemoryRepositoryIsEmpty e) {
            Assert.assertSame(e.getClass(), InMemoryRepositoryIsEmpty.class);
        }
    }

}
