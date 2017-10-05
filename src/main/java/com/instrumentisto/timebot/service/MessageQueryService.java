package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;

/**
 * Describes processing of concrete bot command.
 */
public interface MessageQueryService {

    /**
     * Takes message, ejects ID of recipient and forms answer.
     *
     * @param message message which need to process.
     */
    Message queryProcessor(Message message);
}
