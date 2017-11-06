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
     * Key which used for access to GoogleMaps API.
     */
    @Value("${google.api.key}")
    private String key;

    /**
     * Default latitude.
     */
    @Value("${location.default.latitude}")
    private double defaultLatitude;

    /**
     * Default longitude.
     */
    @Value("${location.default.longitude}")
    private double defaultLongitude;

    /**
     * Default username.
     */
    @Value("${username.default}")
    private String defaultUsername;

    /**
     * Default message for {@code /start} command.
     */
    @Value("${service.start.message}")
    private String startMessage;

    /**
     * Returns {@link GeoApiContext} bean for our key.
     *
     * @return {@link GeoApiContext} value.
     */
    @Bean
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder().apiKey(key).build();
    }

    /**
     * Returns default latitude.
     *
     * @return double value.
     */
    @Bean
    public double getDefaultLatitude() {
        return this.defaultLatitude;
    }

    /**
     * Returns default longitude.
     *
     * @return double value.
     */
    @Bean
    public double getDefaultLongitude() {
        return this.defaultLongitude;
    }

    /**
     * Returns default username.
     *
     * @return {@link String} value.
     */
    @Bean
    public String getDefaultUsername() {
        return defaultUsername;
    }

    /**
     * Returns message of start command.
     *
     * @return {@link String} value.
     */
    @Bean
    public String getStartMessage() {
        return startMessage;
    }
}
