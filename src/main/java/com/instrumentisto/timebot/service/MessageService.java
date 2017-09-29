package com.instrumentisto.timebot.service;

/**
 * This interface is describing of Service which process some query-message which was got from API.
 */
public interface MessageService extends Runnable {


    /**
     * This method loads list of updates and process all of them.
     */
    void updateService();
}
