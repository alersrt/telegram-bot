package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;

/**
 * Describes processor of concrete bot's command.
 */
public interface MessageQueryService {

    /**
     * Takes message, ejects ID of recipient and forms answer.
     *
     * @param message is message which need to process.
     */
    void queryAnswer(Message message);
}
