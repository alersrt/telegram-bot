package com.instrumentisto.timebot.externalAPI;

import com.instrumentisto.timebot.config.wrapper.googlemapsapi.TimeZoneApiNonStaticWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link GeoAPI}.
 */
@Component
public class GoogleMapsAPI implements GeoAPI {

    /**
     * Wrapper which used for testiable arch.
     */
    @Autowired
    private TimeZoneApiNonStaticWrapper timeZoneApiNonStaticWrapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTimeZoneId(double latitude, double longitude) {
        return timeZoneApiNonStaticWrapper.getTimeZone(latitude, longitude)
            .getID();
    }
}
