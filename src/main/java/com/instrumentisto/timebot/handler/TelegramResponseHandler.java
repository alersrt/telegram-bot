package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryIsEmpty;
import com.instrumentisto.timebot.service.MessageTransferService;
import com.instrumentisto.timebot.util.ConverterUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ResponseHandler}.
 */
@Component
public class TelegramResponseHandler implements ResponseHandler {

    /**
     * Injection of {@link com.instrumentisto.timebot.service.TelegramMessageTransferService}
     * for {@link MessageTransferService}.
     */
    @Autowired
    @Qualifier("telegramMessageTransferService")
    private MessageTransferService messageTransferService;

    /**
     * Injection of {@link com.instrumentisto.timebot.util.TelegramMessageConverterUtil}
     * for {@link ConverterUtil}.
     */
    @Autowired
    @Qualifier("telegramMessageConverterUtil")
    private ConverterUtil<Message> converterUtil;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<BaseDTO> handleResponse()
        throws InMemoryRepositoryIsEmpty, DTOConversionIsNotPossible {

        List<Message> repositoryMessages = messageTransferService.getMessages();

        if (!repositoryMessages.isEmpty()) {
            List<BaseDTO> sendMessages = repositoryMessages
                .stream()
                .map(converterUtil::toDTO).collect(Collectors.toList());
            messageTransferService.clearRepository();
            return sendMessages;
        } else {
            throw new InMemoryRepositoryIsEmpty();
        }
    }
}
