package com.instrumentisto.timebot.service;

import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.externalAPI.GeoAPI;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit-test for {@link TelegramMessageQueryTimeService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelegramMessageQueryTimeServiceTest {

    /**
     * Mocked {@link GeoAPI} field.
     */
    @Mock
    private GeoAPI geoAPI;

    /**
     * Tested object.
     */
    @InjectMocks
    private TelegramMessageQueryTimeService timeService = new TelegramMessageQueryTimeService();

    /**
     * Test for {@code queryProcessor(Message message)} method.
     *
     * Checks assertions:
     * 1. Output {@link Message} must not be null;
     * 2. Output message must be equals to another message, text field of which
     * was sets of hands.
     */
    @Test
    public void queryProcessor() throws Exception {
        when(geoAPI.getTimeZoneId(51.28, 0.0)).thenReturn("Europe/London");

        String datetimePattern = "yyyy-MM-dd HH:mm:ss.SSS";

        Message message = new Message();
        message.setChatId("1");

        Field datetimeformatField = TelegramMessageQueryTimeService.class
            .getDeclaredField("datetimeformat");
        boolean accessible = datetimeformatField.isAccessible();
        datetimeformatField.setAccessible(true);
        datetimeformatField.set(timeService, datetimePattern);
        datetimeformatField.setAccessible(accessible);

        Message outMessage = timeService.queryProcessor(message);

        String outDateTime = outMessage.getText();

        LocalDateTime localDateTime = LocalDateTime
            .parse(outDateTime, DateTimeFormatter.ofPattern(datetimePattern));
        message.setText(
            localDateTime.format(DateTimeFormatter.ofPattern(datetimePattern)));

        Assert.assertNotNull(outMessage);
        Assert.assertEquals(message, outMessage);
    }
}
