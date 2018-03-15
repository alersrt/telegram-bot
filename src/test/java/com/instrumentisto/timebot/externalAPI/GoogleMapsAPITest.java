package com.instrumentisto.timebot.externalAPI;

import static org.mockito.Mockito.doReturn;

import com.google.maps.GeoApiContext;
import com.instrumentisto.timebot.config.wrapper.googlemapsapi.TimeZoneApiNonStaticWrapper;
import java.util.TimeZone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit-test for {@link GoogleMapsAPI}.
 */
@RunWith(MockitoJUnitRunner.class)
public class GoogleMapsAPITest {

    /**
     * Mock of {@link GeoApiContext} field.
     */
    @Mock
    private TimeZoneApiNonStaticWrapper timeZoneApiNonStaticWrapper;

    /**
     * {@link GoogleMapsAPI} object with mocked fields.
     */
    @InjectMocks
    private GoogleMapsAPI googleMapsAPI = new GoogleMapsAPI();

    /**
     * Test for {@code getTimeZoneId(...)} method.
     *
     * Checks assertion:
     * Received TimeZoneId for [ltd=51.28,lng=0.00] must be equals to
     * "Europe/London".
     */
    @Test
    public void testGetTimeZoneId() {

        doReturn(TimeZone.getTimeZone("Europe/London"))
            .when(timeZoneApiNonStaticWrapper).getTimeZone(51.28, 0);

        Assert.assertEquals("Europe/London",
            googleMapsAPI.getTimeZoneId(51.28, 0));
    }
}
