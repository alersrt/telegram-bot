package com.instrumentisto.timebot.conf;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Doc comment?
@Configuration
public class TelegramConfig {

    @Value("${bot.token}")
    String botToken;

    @Bean
    TelegramBot telegramBot() {
        return TelegramBotAdapter.build(botToken);
    }
}
