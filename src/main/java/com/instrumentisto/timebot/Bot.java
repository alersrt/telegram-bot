package com.instrumentisto.timebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Time Bot is a application that implements Telegram bot API.
 * This application should return the current time to GMT, in response to the
 * request "/time" of the user of the messenger "Telegram".
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:botsettings/settings.propeties")
public class Bot {

    public Bot() {
        System.out.println("Hello, I am a Bot");
    }

    /**
     * Just runs new Spring application with arguments from CLI.
     *
     * @param args String[]   CLI arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(Bot.class, args);
    }
}
