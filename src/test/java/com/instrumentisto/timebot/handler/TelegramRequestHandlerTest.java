package com.instrumentisto.timebot.handler;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.entity.User;
import com.instrumentisto.timebot.repository.MessageRepository;
import com.instrumentisto.timebot.repository.UserRepository;
import com.instrumentisto.timebot.service.MessageQueryService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

/**
 * Unit-test for {@link TelegramRequestHandler}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramRequestHandlerTest {

    /**
     * Mock for converter.
     */
    @Mock
    private ConversionService converter;

    /**
     * Mock for {@link MessageRepository}.
     */
    @Mock
    private MessageRepository messageRepository;

    /**
     * Mock for {@link UserRepository}.
     */
    @Mock
    private UserRepository userRepository;

    /**
     * Mock for {@link com.instrumentisto.timebot.service.TelegramMessageQueryDefaultService}.
     */
    @Mock
    private MessageQueryService defaultService;

    /**
     * Mock for {@link com.instrumentisto.timebot.service.TelegramMessageQueryStartService}.
     */
    @Mock
    private MessageQueryService startService;

    /**
     * Mock for {@link com.instrumentisto.timebot.service.TelegramMessageQueryTimeService}.
     */
    @Mock
    private MessageQueryService timeService;

    /**
     * Object of tested class.
     */
    @InjectMocks
    private RequestHandler requestHandler = new TelegramRequestHandler();

    /**
     * Mock of test {@link com.instrumentisto.timebot.DTO.MessageDTO}.
     */
    @Mock
    private MessageDTO messageDTO;

    /**
     * Mock of {@link Message} for default branch.
     */
    @Mock
    private Message defaultMessage;

    /**
     * Mock of {@link Message} for "/start" message.
     */
    @Mock
    private Message startMessage;

    /**
     * Mock of {@link Message} for "/time message".
     */
    @Mock
    private Message timeMessage;

    /**
     * Mock of {@link Message} for test of main method.
     */
    @Mock
    private Message baseMessage;

    /**
     * Mock of {@link User} for test of main method.
     */
    @Mock
    private User user;


    /**
     * Init boundaries for this test.
     */
    @Before
    public void setUp() {
        when(defaultMessage.getText()).thenReturn("");
        when(defaultMessage.getUser()).thenReturn(user);

        when(startMessage.getText()).thenReturn("/start");
        when(startMessage.getUser()).thenReturn(user);

        when(timeMessage.getText()).thenReturn("/time");
        when(timeMessage.getUser()).thenReturn(user);

        when(defaultService.queryProcessor(defaultMessage))
            .thenReturn(defaultMessage);
        when(startService.queryProcessor(startMessage))
            .thenReturn(startMessage);
        when(timeService.queryProcessor(timeMessage)).thenReturn(timeMessage);

        when(baseMessage.getUser()).thenReturn(user);
        when(user.getApiId()).thenReturn("12");
    }

    /**
     * Test for {@code handleRequest()} method. If user does not contains in
     * repository that he must be saved there.
     *
     * Check assertion: User must be contained in repository.
     */
    @Test
    public void handleRequest_userIsNotInDatabase_returnTrue() {
        when(converter.convert(messageDTO, Message.class))
            .thenReturn(baseMessage);

        List<User> userList = new ArrayList<>();
        doAnswer(invocation -> {
            userList.add(invocation.getArgument(0));
            return invocation.getArgument(0);
        }).when(userRepository).save(user);

        when(userRepository.findByApiId("12")).thenReturn(null);

        requestHandler.handleRequest(messageDTO);

        Assert.assertTrue(userList.contains(user));
    }

    /**
     * Test for {@code handleRequest} method. If user is contained in repository
     * but location is default then contained user assign into message (because
     * of
     * Spring Data JPA).
     *
     * Check assertion: new user is not added to repository (list size equals to
     * 1).
     */
    @Test
    public void handleRequest_userInDatabaseAndLocationIsDefault_returnTrue() {
        when(converter.convert(messageDTO, Message.class))
            .thenReturn(baseMessage);
        when(messageDTO.isLocationDefault()).thenReturn(true);
        when(userRepository.findByApiId("12")).thenReturn(user);

        User trashUser = mock(User.class);
        when(trashUser.getApiId()).thenReturn("12");
        when(baseMessage.getUser()).thenReturn(trashUser);

        List<User> userList = new ArrayList<>();
        userList.add(user);

        requestHandler.handleRequest(messageDTO);

        Assert.assertTrue(userList.size() == 1 && user.equals(userList.get(0)));
    }

    /**
     * Test for {@code handleRequest} method. If user is contained in repository
     * and location is not default then contained user is changed, saved into
     * repository and assigned into message (because of Spring Data JPA).
     *
     * Check assertion: new user is added to repository (list size must be equals
     * to 2).
     */
    @Test
    public void handleRequest_userInDatabaseAndLocationIsNotDefault_returnTrue() {
        when(converter.convert(messageDTO, Message.class))
            .thenReturn(baseMessage);
        when(messageDTO.isLocationDefault()).thenReturn(false);

        User newUser = spy(User.class);
        when(newUser.getApiId()).thenReturn("12");
        when(baseMessage.getUser()).thenReturn(newUser);
        when(userRepository.findByApiId("12")).thenReturn(newUser);

        List<User> userList = new ArrayList<>();
        userList.add(newUser);
        doAnswer(invocation -> {
            userList.add(invocation.getArgument(0));
            return invocation.getArgument(0);
        }).when(userRepository).save(newUser);

        requestHandler.handleRequest(messageDTO);

        Assert.assertTrue(userList.size() == 2);
    }

    /**
     * Test for {@code handleRequest} method. Message repo must contains
     * defaultMessage.
     *
     * Check assertion: message repository must contains defaultMessage.
     */
    @Test
    public void handleRequest_handleDefaultMessage_returnTrue() {
        when(converter.convert(messageDTO, Message.class))
            .thenReturn(defaultMessage);
        when(messageDTO.isLocationDefault()).thenReturn(true);

        List<Message> messageList = new ArrayList<>();
        doAnswer(invocation -> {
            messageList.add(invocation.getArgument(0));
            return invocation.getArgument(0);
        }).when(messageRepository).save(defaultMessage);

        requestHandler.handleRequest(messageDTO);

        Assert.assertTrue(messageList.contains(defaultMessage));
    }

    /**
     * Test for {@code handleRequest} method. Message repo must contains
     * startMessage.
     *
     * Check assertion: message repository must contains startMessage.
     */
    @Test
    public void handleRequest_handleStartMessage_returnTrue() {
        when(converter.convert(messageDTO, Message.class))
            .thenReturn(startMessage);
        when(messageDTO.isLocationDefault()).thenReturn(true);

        List<Message> messageList = new ArrayList<>();
        doAnswer(invocation -> {
            messageList.add(invocation.getArgument(0));
            return invocation.getArgument(0);
        }).when(messageRepository).save(startMessage);

        requestHandler.handleRequest(messageDTO);

        Assert.assertTrue(messageList.contains(startMessage));
    }

    /**
     * Test for {@code handleRequest} method. Message repo must contains
     * timeMessage.
     *
     * Check assertion: message repository must contains timeMessage.
     */
    @Test
    public void handleRequest_handleTimeMessage_returnTrue() {
        when(converter.convert(messageDTO, Message.class))
            .thenReturn(timeMessage);
        when(messageDTO.isLocationDefault()).thenReturn(true);

        List<Message> messageList = new ArrayList<>();
        doAnswer(invocation -> {
            messageList.add(invocation.getArgument(0));
            return invocation.getArgument(0);
        }).when(messageRepository).save(timeMessage);

        requestHandler.handleRequest(messageDTO);

        Assert.assertTrue(messageList.contains(timeMessage));
    }
}
