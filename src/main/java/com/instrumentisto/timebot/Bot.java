package com.instrumentisto.timebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Time Bot is a application that implements Telegram bot API. This application should return the
 * current time to GMT, in response to the request "/time" of the user of the messenger "Telegram".
 */
@SpringBootApplication
public class Bot {

    public Bot() {
        System.out.println("Hello, I am a Bot");
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

