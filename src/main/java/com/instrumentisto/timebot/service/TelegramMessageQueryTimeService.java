package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.externalAPI.GeoAPI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageQueryService} for {@code "/time"} command.
 */
@Service
public class TelegramMessageQueryTimeService implements MessageQueryService {

    /**
     * Format of DateTime which injects from properties.
     */
    @Value("${bot.datetime.format}")
    private String datetimeformat;

    /**
     * Autowired field for external geolocation API.
     */
    @Autowired
    @Qualifier("googleMapsAPI")
    private GeoAPI geoAPI;

    /**
     * {@inheritDoc}
     */
    @Override
    public Message queryProcessor(Message message) {
        double[] location = message.getLocation();
        String timezoneId = geoAPI.getTimeZoneId(location[0], location[1]);

        LocalDateTime localDateTime = LocalDateTime
            .now(ZoneId.of(timezoneId));
        String datetime = localDateTime
            .format(DateTimeFormatter.ofPattern(datetimeformat));
        message.setText(datetime);
        return message;
    }
}
