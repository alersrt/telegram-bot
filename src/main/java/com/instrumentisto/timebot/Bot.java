package com.instrumentisto.timebot;

import com.instrumentisto.timebot.conf.logging.Logging;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Time Bot is a application that implements Telegram bot API. This application should return the
 * current time to GMT, in response to the request "/time" of the user of the messenger "Telegram".
 */
@SpringBootApplication
public class Bot {

    @Logging
    private Logger logger;

    /**
     * PostConstructor for {@link Bot}. At the current time moment it does not have any function
     * except informing of user about success start.
     */
    @PostConstruct
    public void init() {
        logger.info("Hello, I am a Bot");
    }

    /**
     * Just runs new Spring application with arguments from CLI.
     *
     * @param args String[]   CLI arguments.
     */
    public static void main(String... args) {
        SpringApplication springApplication = new SpringApplication(Bot.class);
        springApplication.run(args);
    }
}

