package com.instrumentisto.timebot.service;

/**
 * Describes service which will to get new updates from servers and processes each of them.
 */
public interface MessageListService {

    /**
     * Gets messages from server and call necessary query service for each message.
     */
    void processQueries();
}
