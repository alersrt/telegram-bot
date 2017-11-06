package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.repository.MessageRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ResponseHandler}.
 */
@Component
public class TelegramResponseHandler implements ResponseHandler {

    /**
     * Message's repository.
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Conversion Service.
     */
    @Autowired
    private ConversionService converter;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MessageDTO> handleResponse() {

        List<Message> repositoryMessages = messageRepository.findAll();

        List<MessageDTO> sendMessages = repositoryMessages
            .stream()
            .map(m -> converter.convert(m, MessageDTO.class))
            .collect(Collectors.toList());
        messageRepository.deleteAll();
        return sendMessages;
    }
}
