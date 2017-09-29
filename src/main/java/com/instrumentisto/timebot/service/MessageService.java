package com.instrumentisto.timebot.service;

/**
 * Describing of Service which process some queries which was got from Telegram
 * bot API.
 */
public interface MessageService extends Runnable {

    /**
     * Loads list of updates and process all of them by some logic which is set in
     * implementation.
     */
    void updateService();
}
