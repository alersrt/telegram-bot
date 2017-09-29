package com.instrumentisto.timebot;

import com.instrumentisto.timebot.conf.TelegramConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


/**
 * Is main class of Time AI application. You can starts here.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import(TelegramConfig.class)
@PropertySource("classpath:botsettings/settings.propeties")
public class Bot {

    public Bot() {
        System.out.println("Hello, I am a Bot");
    }

    public static void main(String[] args) {
        SpringApplication.run(Bot.class, args);
    }
}
