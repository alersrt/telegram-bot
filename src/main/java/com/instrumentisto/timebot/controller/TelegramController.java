package com.instrumentisto.timebot.controller;

import com.instrumentisto.timebot.conf.logging.Logging;
import com.instrumentisto.timebot.exception.repository.InMemoryRepositoryIsEmpty;
import com.instrumentisto.timebot.handler.RequestHandler;
import com.instrumentisto.timebot.handler.ResponseHandler;
import com.instrumentisto.timebot.util.ConverterUtil;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link BotController}. Main controller of bot.
 */
@Component
public class TelegramController implements BotController {

    /**
     * {@link Logger} exemplar for this controller.
     */
    @Logging
    private Logger logger;

    /**
     * Timeout value which injected from properties file.
     */
    @Value("${bot.timeout}")
    private long timeout;

    /**
     * Exemplar of object for work with Telegram Bot API.
     */
    @Autowired
    TelegramBot telegramBot;

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
     * {@link ConverterUtil} for {@link Update}.
     */
    @Autowired
    private ConverterUtil<Update> updateConverterUtil;

    /**
     * {@link ConverterUtil} for {@link SendMessage}.
     */
    @Autowired
    private ConverterUtil<SendMessage> sendMessageConverterUtil;

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
            updates.stream()
                .map(updateConverterUtil::toDTO)
                .forEach(requestHandler::handleRequest);

            lastUpdateId =
                updates.size() > 0 ? updates.get(updates.size() - 1).updateId()
                    + 1 : 0;

            try {
                responseHandler.handleResponse().stream()
                    .map(sendMessageConverterUtil::fromDTO)
                    .forEach(sm -> {
                        telegramBot.execute(sm);
                        logger.info(String.format("Answer was sent to %s",
                            sm.getParameters().get("chat_id")));
                    });
            } catch (InMemoryRepositoryIsEmpty e) {
                // InMemoryRepositoryIsEmpty exception just talks that repository
                // is empty at the current moment.
            }

            Thread.sleep(timeout);
        }
    }
}
