package com.instrumentisto.timebot.handler;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.service.MessageQueryService;
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
 * Unit-test for {@link TelegramRequestHandler}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramRequestHandlerTest {

    /**
     * Mock {@link ConverterUtil} as dependence for tested {@link RequestHandler}.
     */
    @Mock
    private ConverterUtil converterUtil;

    /**
     * Mock {@link MessageTransferService} as dependence for tested {@link
     * RequestHandler}.
     */
    @Mock
    private MessageTransferService messageTransferService;

    /**
     * Mock {@link MessageQueryService} as dependence for tested {@link
     * RequestHandler}.
     */
    @Mock
    private MessageQueryService timeQueryService;

    /**
     * Mock of {@link RequestHandler} field which initialized of {@link
     * TelegramRequestHandler} and injects its dependencies.
     */
    @InjectMocks
    private RequestHandler requestHandler = new TelegramRequestHandler();

    /**
     * Test for {@code handleRequest(BaseDTO baseDTO)} method.
     *
     * Checks assertions:
     * 1. Message which stored in repo must not be null;
     * 2. Text of this message must be equals to {@code "datetime"}.
     */
    @Test
    public void handleRequest() throws Exception {
        List<Message> messages = new ArrayList<>();

        Message message = mock(Message.class);
        when(message.getText()).thenReturn("t1");

        BaseDTO baseDTO = mock(BaseDTO.class);

        when(converterUtil.fromDTO(baseDTO)).thenReturn(message);

        doAnswer(invocation -> {
            messages.add(invocation.getArgument(0));
            return messages;
        }).when(messageTransferService).saveMessage(message);

        doAnswer(invocation -> {
            when(message.getText()).thenReturn("datetime");
            return message;
        }).when(timeQueryService).queryProcessor(message);

        requestHandler.handleRequest(baseDTO);

        Assert.assertNotNull(messages.get(0));
        Assert.assertEquals("datetime", messages.get(0).getText());
    }

}
