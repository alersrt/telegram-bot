package com.instrumentisto.timebot.handler;

import com.instrumentisto.timebot.DTO.BaseDTO;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.exception.DTO.DTOConversionIsNotPossible;
import com.instrumentisto.timebot.exception.DTO.DTOFieldDoesNotExist;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositorySaveException;
import com.instrumentisto.timebot.service.MessageQueryService;
import com.instrumentisto.timebot.service.MessageTransferService;
import com.instrumentisto.timebot.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link RequestHandler}.
 */
@Component
public class TelegramRequestHandler implements RequestHandler {

    /**
     * Converter which needs for converting {@link BaseDTO} to {@link Message}.
     */
    @Autowired
    @Qualifier("telegramMessageConverterUtil")
    private ConverterUtil<Message> converterUtil;

    /**
     * {@link MessageTransferService} which works with repository.
     */
    @Autowired
    @Qualifier("telegramMessageTransferService")
    private MessageTransferService messageTransferService;

    /**
     * {@link MessageQueryService} which process concrete query.
     */
    @Autowired
    @Qualifier("telegramMessageQueryTimeService")
    private MessageQueryService timeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleRequest(BaseDTO baseDTO)
        throws DTOConversionIsNotPossible, DTOFieldDoesNotExist,
        InMemoryRepositorySaveException {
        Message message = converterUtil.fromDTO(baseDTO);

        messageTransferService.saveMessage(timeService.queryProcessor(message));
    }
}
