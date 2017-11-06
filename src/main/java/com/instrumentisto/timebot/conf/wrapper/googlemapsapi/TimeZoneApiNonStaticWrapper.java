package com.instrumentisto.timebot.conf.wrapper.googlemapsapi;

import com.google.maps.GeoApiContext;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Wrapper for {@link TimeZoneApi}.
 */
@Component
public class TimeZoneApiNonStaticWrapper {

    /**
     * {@link GeoApiContext} which used in {@link TimeZoneApi}.
     */
    @Autowired
    private GeoApiContext geoApiContext;

    /**
     * Nonstatic method which need wor getting of {@link TimeZone} from {@link
     * TimeZoneApi}.
     *
     * @param latitude latitude parameter.
     * @param longitude longitude parameter.
     * @return {@link TimeZone} value.
     */
    public TimeZone getTimeZone(double latitude, double longitude) {
        return TimeZoneApi
            .getTimeZone(geoApiContext, new LatLng(latitude, longitude))
            .awaitIgnoreError();
    }
}
