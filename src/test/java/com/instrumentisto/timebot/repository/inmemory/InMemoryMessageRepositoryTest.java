package com.instrumentisto.timebot.repository.inmemory;

import com.instrumentisto.timebot.entity.Message;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link InMemoryMessageRepository}.
 */
public class InMemoryMessageRepositoryTest {

    /**
     * Test for {@code getIdSequencer()} and {@code setIdSequencer(int
     * idSequencer)} methods.
     *
     * Checks assertions:
     * 1. Set the {@code idSequencer} to 3;
     * 2. Got {@code idSequencer} must be equal 3.
     */
    @Test
    public void testGetSetIdSequencer() {
        InMemoryMessageRepository messageRepository = new InMemoryMessageRepository();

        messageRepository.setIdSequencer(3);

        Assert.assertEquals(3, messageRepository.getIdSequencer());
    }

    /**
     * Test for {@code findById(int id)} method.
     *
     * Checks assertions:
     * 1. Found {@link Message} must not be null;
     * 2. Found {@link Message} must be equals to message which we placed into
     * the repository before.
     */
    @Test
    public void findById_equalityOfOriginalMessageAndResult_returnOk()
        throws Exception {
        InMemoryMessageRepository messageRepository = new InMemoryMessageRepository();
        Message message1 = new Message();
        Message message2 = new Message();

        message1.setId(1);
        message1.setText("t1");
        message1.setChatId("1");

        message2.setId(2);
        message2.setText("t2");
        message2.setChatId("2");

        List<Message> repository = new ArrayList<>();
        repository.add(message1);
        repository.add(message2);

        messageRepository.setRepository(repository);
        messageRepository.setIdSequencer(3);

        Assert.assertNotNull(messageRepository.findById(1));
        Assert.assertEquals(message1, messageRepository.findById(1));
    }

    /**
     * Test for {@code saveMessage(message)} method.
     *
     * Checks assertion:
     * {@link Message} which saved in to repository must be equals to object which
     * contain in inner collections of repository.
     */
    @Test
    public void saveMessage_equalityOfOriginalAndSavedMessages_returnOk()
        throws Exception {
        InMemoryMessageRepository messageRepository = new InMemoryMessageRepository();

        Message message1 = new Message();
        message1.setId(1);
        message1.setText("t1");
        message1.setChatId("1");

        Message message2 = new Message();
        message2.setId(2);
        message2.setText("t2");
        message2.setChatId("2");

        List<Message> repository = new ArrayList<>();
        repository.add(message1);
        repository.add(message2);

        messageRepository.setRepository(repository);
        messageRepository.setIdSequencer(3);

        Message message3 = new Message();
        message3.setId(3);
        message2.setText("t3");
        message2.setChatId("3");

        messageRepository.saveMessage(message3);

        Assert.assertEquals(message3,
            messageRepository.getRepository().stream()
                .filter(m -> m.getId() == 3).findFirst()
                .get());
    }

    /**
     * Test for {@code getAllMessages()} method.
     *
     * Checks assertions:
     * 1. Returned {@link List} of {@link Message} must not be equals to null;
     * 2. All {@link Message} which was insert in to repository before must be
     * presence in returned {@link List}.
     */
    @Test
    public void getAllMessages_repositoryContainsAllMessages_returnOk()
        throws Exception {
        InMemoryMessageRepository messageRepository = new InMemoryMessageRepository();
        Message message1 = new Message();
        Message message2 = new Message();

        message1.setId(1);
        message1.setText("t1");
        message1.setChatId("1");

        message2.setId(2);
        message2.setText("t2");
        message2.setChatId("2");

        List<Message> repository = new ArrayList<>();
        repository.add(message1);
        repository.add(message2);

        messageRepository.setRepository(repository);
        messageRepository.setIdSequencer(3);

        Assert.assertNotNull(messageRepository.getAllMessages());
        Assert.assertTrue(messageRepository.getAllMessages().contains(message1)
            && messageRepository
            .getAllMessages().contains(message2));
    }

    /**
     * Test for {@code removeAll()} method.
     *
     * Checks assertions:
     * 1. Before executing of this method inner collection must not be null;
     * 2. After this executing of this method inner collection must be empty.
     */
    @Test
    public void removeAll_repositoryIsClear_returnOk() throws Exception {
        InMemoryMessageRepository messageRepository = new InMemoryMessageRepository();
        Message message1 = new Message();
        Message message2 = new Message();

        message1.setId(1);
        message1.setText("t1");
        message1.setChatId("1");

        message2.setId(2);
        message2.setText("t2");
        message2.setChatId("2");

        List<Message> repository = new ArrayList<>();
        repository.add(message1);
        repository.add(message2);

        messageRepository.setRepository(repository);
        messageRepository.setIdSequencer(3);

        Assert.assertTrue(!messageRepository.getRepository().isEmpty());

        messageRepository.removeAll();

        Assert.assertTrue(messageRepository.getRepository().isEmpty());
    }
}
