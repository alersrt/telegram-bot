package com.instrumentisto.timebot.controller;

import com.instrumentisto.timebot.DTO.MessageDTO;
import com.instrumentisto.timebot.handler.RequestHandler;
import com.instrumentisto.timebot.handler.ResponseHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link BotController}. Main controller of bot.
 */
@Slf4j
@Component
public class TelegramController implements BotController {

    /**
     * Timeout value which injected from properties file.
     */
    @Value("${bot.timeout}")
    private long timeout;

    /**
     * Exemplar of object for work with Telegram Bot API.
     */
    @Autowired
    private TelegramBot telegramBot;

    /**
     * {@link RequestHandler} exemplar.
     */
    @Autowired
    private RequestHandler requestHandler;

    /**
     * {@link ResponseHandler} exemplar.
     */
    @Autowired
    private ResponseHandler responseHandler;

    /**
     * Conversion Service from Spring
     */
    @Autowired
    private ConversionService converter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        int lastUpdateId = 0;

        while (!Thread.currentThread().isInterrupted()) {
            GetUpdates getUpdates = new GetUpdates().offset(lastUpdateId);
            GetUpdatesResponse getUpdatesResponse = telegramBot
                .execute(getUpdates);

            List<Update> updates = getUpdatesResponse.updates();
            updates.stream().filter(u -> u.message() != null)
                .map(u -> converter.convert(u.message(), MessageDTO.class))
                .forEach(requestHandler::handleRequest);

            lastUpdateId =
                updates.size() > 0 ? updates.get(updates.size() - 1).updateId()
                    + 1 : 0;

            responseHandler.handleResponse().stream()
                .map(m -> converter.convert(m, SendMessage.class))
                .forEach(sm -> {
                    telegramBot.execute(sm);
                    log.info(String.format("Answer was sent to %s",
                        sm.getParameters().get("chat_id")));
                });

            Thread.sleep(timeout);
        }
    }
}
