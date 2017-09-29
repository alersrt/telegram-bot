package com.instrumentisto.timebot.service;

/**
 * This interface is describing of Service which process some queries which was got from API.
 */
public interface MessageService extends Runnable {


    /**
     * This method loads list of updates and process all of them by some logic which is set in
     * implementation.
     */
    void updateService();
}
