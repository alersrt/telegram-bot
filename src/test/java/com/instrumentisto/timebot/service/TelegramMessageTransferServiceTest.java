package com.instrumentisto.timebot.service;

import static org.mockito.Mockito.mock;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.repository.MessageRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Unit-test for {@link TelegramMessageTransferService}
 */
public class TelegramMessageTransferServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageTransferService transferService = new TelegramMessageTransferService();

    private Message message;

    /**
     * Test for {@code saveMessage()} method.
     */
    @Test
    public void saveMessage() throws Exception {
        message = new Message();
        message.setId(1);
        message.setText("t1");
        message.setChatId("1");
    }

    /**
     * Test for {@code findById()} method.
     */
    @Test
    public void findById() throws Exception {
        // TODO: Need to realize

        TelegramMessageTransferService transferService = mock(
            TelegramMessageTransferService.class
        );


    }

    /**
     * Test for {@code getMessages()} method.
     */
    @Test
    public void getMessages() throws Exception {
        // TODO: Need to realize
    }

    /**
     * Test for {@code clearRepository} method.
     */
    @Test
    public void clearRepository() throws Exception {
        // TODO: Need to realize
    }
}
