package com.instrumentisto.timebot.conf;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration file for GoogleMaps API
 */
@Configuration
@PropertySource("classpath:telegramBot.properties")
public class GoogleMapsAPIConfig {

    /**
     * Key which used for access to GoogleMaps API
     */
    @Value("${google.api.key}")
    private String key;

    /**
     * Returns {@link GeoApiContext} bean for our key.
     *
     * @return {@link GeoApiContext} value.
     */
    @Bean
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder().apiKey(key).build();
    }
}
