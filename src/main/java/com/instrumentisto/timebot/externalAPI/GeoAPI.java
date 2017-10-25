package com.instrumentisto.timebot.externalAPI;

/**
 * Describes interaction with external API for getting information about
 * timezones by coordinates, etc.
 */
public interface GeoAPI {

    /**
     * Returns TimeZoneId by coordinates (latitude, longitude).
     *
     * @param latitude coordinate of latitude.
     * @param longitude coordinate of longitude.
     * @return {@link String} value of TimeZoneId.
     */
    String getTimeZoneId(double latitude, double longitude);
}
