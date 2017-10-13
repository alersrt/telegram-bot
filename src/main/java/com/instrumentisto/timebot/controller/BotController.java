package com.instrumentisto.timebot.controller;

import org.springframework.boot.ApplicationRunner;

/**
 * Describes controller which is entry point for API data's. In the {@code
 * run()} method commits call of handlers for processing input data. The
 * interface inherited from {@link ApplicationRunner}. It is a marker which
 * indicates about class-controller.
 */
public interface BotController extends ApplicationRunner {
    //  Does not needs to realize.
}
