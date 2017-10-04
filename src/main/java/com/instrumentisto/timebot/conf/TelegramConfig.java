package com.instrumentisto.timebot.conf;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:telegramBot.properties")
/**
 * Spring configuration file for Telegram API bot.
 */
public class TelegramConfig {

    @Value("${bot.token}")
    /**
     * Token's value which injects from properties file.
     */
    String botToken;

    @Bean
    /**
     * Returns {@link TelegramBot} bean for our token.
     *
     * @return {@link TelegramBot} value
     */
    TelegramBot telegramBot() {
        return TelegramBotAdapter.build(botToken);
    }
}
