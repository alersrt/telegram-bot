package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.entity.User;
import com.instrumentisto.timebot.repository.MessageRepository;
import com.instrumentisto.timebot.repository.UserRepository;
import com.instrumentisto.timebot.service.MessageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link RequestHandler}.
 */
@Component
public class TelegramRequestHandler implements RequestHandler {

    /**
     * Conversion service.
     */
    @Autowired
    private ConversionService converter;

    /**
     * {@link MessageQueryService} which process "time" query.
     */
    @Autowired
    @Qualifier("telegramMessageQueryTimeService")
    private MessageQueryService timeService;

    /**
     * {@link MessageQueryService} which process "start" query.
     */
    @Autowired
    @Qualifier("telegramMessageQueryStartService")
    private MessageQueryService startService;

    /**
     * {@link MessageQueryService} which process any queries except those which
     * is determined.
     */
    @Autowired
    @Qualifier("telegramMessageQueryDefaultService")
    private MessageQueryService defaultService;

    /**
     * User's repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Message's repository.
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleRequest(MessageDTO messageDTO) {
        Message message = converter.convert(messageDTO, Message.class);
        boolean isLocationDefault = messageDTO.isLocationDefault();

        User existsUser = userRepository.findByApiId(message.getUser().getApiId());

        if (existsUser == null) {
            userRepository.save(message.getUser());
        } else {
            if (!isLocationDefault) {
                existsUser.setLatitude(message.getUser().getLatitude());
                existsUser.setLongitude(message.getUser().getLongitude());
                userRepository.save(existsUser);
            }
            message.setUser(existsUser);
        }

        checkCommand(message, isLocationDefault);
    }

    private void checkCommand(Message message, boolean isLocationDefault) {
        String command = message.getText();

        if ("/time".equals(command)) {
            messageRepository.save(timeService.queryProcessor(message));
        } else if ("/start".equals(command)) {
            messageRepository.save(startService.queryProcessor(message));
        } else if (isLocationDefault) {
            messageRepository.save(defaultService.queryProcessor(message));
        }
    }
}
