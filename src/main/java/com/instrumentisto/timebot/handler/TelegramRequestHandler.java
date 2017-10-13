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
     * {@inheritDoc}
     */
    @Override
    public void handleRequest(BaseDTO baseDTO)
        throws DTOConversionIsNotPossible, DTOFieldDoesNotExist,
        InMemoryRepositorySaveException {

        Message message = converterUtil.fromDTO(baseDTO);
        switch (message.getText()) {
            case "/time":
                messageTransferService
                    .saveMessage(timeService.queryProcessor(message));
                break;
            case "/start":
                messageTransferService
                    .saveMessage(startService.queryProcessor(message));
                break;
            default:
                messageTransferService
                    .saveMessage(defaultService.queryProcessor(message));
                break;
        }

    }
}
