package com.instrumentisto.timebot.service;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

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

/**
 * Unit-test for {@link TelegramMessageTransferService}
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramMessageTransferServiceTest {

    /**
     * It is {@link MessageRepository} field to which {@link
     * MessageTransferService} works.
     */
    @Mock
    private MessageRepository messageRepository;

    /**
     * {@link MessageTransferService} field which initialized of our {@link
     * TelegramMessageTransferService} class.
     */
    @InjectMocks
    private MessageTransferService transferService = new TelegramMessageTransferService();

    /**
     * {@link Message} field which will be our test rabbit which will to run to
     * there and back.
     */
    private Message message;

    /**
     * Test for {@code saveMessage()} method.
     *
     * Checks assertion:
     * {@link Message} which contains in repository after saving must be equals
     * to object which was saved.
     */
    @Test
    public void saveMessage() throws Exception {
        List<Message> messages = new ArrayList<>();

        int messageId = 1;
        message = new Message();
        message.setId(messageId);
        message.setText("t1");
        message.setChatId("1");

        doAnswer(invocation -> {
            messages.add(invocation.getArgument(0));
            return messages;
        }).when(messageRepository).saveMessage(message);

        transferService.saveMessage(message);

        Assert.assertEquals(message,
            messages.stream().filter(m -> m.equals(message)).findFirst().get());
    }

    /**
     * Test for {@code findById()} method.
     *
     * Checks assertions:
     * 1. Retrieved {@link Message} must not be null;
     * 2. Retrieved object must be equals to object which stored in repository
     * under specified ID.
     */
    @Test
    public void findById() throws Exception {
        int messageId = 1;
        message = new Message();
        message.setId(messageId);
        message.setText("t1");
        message.setChatId("1");

        when(messageRepository.findById(messageId)).thenReturn(message);

        Message retrievedMessage = transferService.findById(messageId);

        Assert.assertNotNull(retrievedMessage);
        Assert.assertEquals(message, retrievedMessage);
    }

    /**
     * Test for {@code getMessages()} method.
     *
     * Checks assertions:
     * 1. Retrieved {@link List} of {@link Message} must not be null;
     * 2. Retrieved list of messages must be equals to inner list on repository.
     */
    @Test
    public void getMessages() throws Exception {
        List<Message> messageList = new ArrayList<>();

        int messageId = 1;
        message = new Message();
        message.setId(messageId);
        message.setText("t1");
        message.setChatId("1");

        messageList.add(message);

        when(messageRepository.getAllMessages()).thenReturn(messageList);

        List<Message> retrievedListOfMessages = transferService.getMessages();

        Assert.assertNotNull(retrievedListOfMessages);
        Assert.assertEquals(messageList, retrievedListOfMessages);
    }

    /**
     * Test for {@code clearRepository} method.
     *
     * Checks assertion:
     * Nonempty inner repository's {@link List} of {@link Message} must be empty
     * after call of this method.
     */
    @Test
    public void clearRepository() throws Exception {
        List<Message> messages = new ArrayList<>();

        int messageId = 1;
        message = new Message();
        message.setId(messageId);
        message.setText("t1");
        message.setChatId("1");

        messages.add(message);

        doAnswer(invocation -> {
            messages.clear();
            return messages;
        }).when(messageRepository).removeAll();

        transferService.clearRepository();

        Assert.assertEquals(new ArrayList<Message>(), messages);
    }
}
