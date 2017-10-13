package com.instrumentisto.timebot.conf;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration file for Telegram API bot.
 */
@Configuration
@PropertySource("classpath:telegramBot.properties")
public class TelegramConfig {

    /**
     * Token's value which injects from properties file.
     */
    @Value("${bot.token}")
    private String botToken;

    /**
     * Returns {@link TelegramBot} bean for our token.
     *
     * @return {@link TelegramBot} value
     */
    @Bean
    TelegramBot telegramBot() {
        return TelegramBotAdapter.build(botToken);
    }
}
