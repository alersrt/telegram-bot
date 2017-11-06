package com.instrumentisto.timebot.conf;

import com.instrumentisto.timebot.converter.MessageDTOToMessageConverter;
import com.instrumentisto.timebot.converter.MessageDTOToTelegramSendMessageConverter;
import com.instrumentisto.timebot.converter.MessageToMessageDTOConverter;
import com.instrumentisto.timebot.converter.TelegramMessageToMessageDTOConverter;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

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
     * @return {@link TelegramBot} value.
     */
    @Bean
    TelegramBot telegramBot() {
        return TelegramBotAdapter.build(botToken);
    }

    /**
     * Injection for Conversion service
     */
    @Autowired
    TelegramMessageToMessageDTOConverter telegramMessageToMessageDTOConverter;

    /**
     * Returns Spring conversion service
     *
     * @return {@link ConversionServiceFactoryBean} object.
     */
    @Bean
    ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new MessageToMessageDTOConverter());
        converters.add(new MessageDTOToMessageConverter());
        converters.add(new MessageDTOToTelegramSendMessageConverter());
        converters.add(telegramMessageToMessageDTOConverter);
        bean.setConverters(converters);
        return bean;
    }
}
