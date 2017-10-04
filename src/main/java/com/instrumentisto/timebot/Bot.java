package com.instrumentisto.timebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Time Bot is a application that implements Telegram bot API. This application should return the
 * current time to GMT, in response to the request "/time" of the user of the messenger "Telegram".
 */
public class Bot {

    //TODO:Doc?
    public Bot() {
        //TODO: Now you can use a logger. Is not it?
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

