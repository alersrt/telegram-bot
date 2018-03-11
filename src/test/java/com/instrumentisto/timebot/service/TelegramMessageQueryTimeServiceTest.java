package com.instrumentisto.timebot.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.entity.User;
import com.instrumentisto.timebot.externalAPI.GeoAPI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.reflect.FieldUtils;
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
     * TObject of testing class.
     */
    @InjectMocks
    private MessageQueryService queryService = new TelegramMessageQueryTimeService();

    /**
     * Test for queryProcessor() method.
     *
     * Check assertion: output message must be equals to another message, text
     * field of which was sets of hands.
     */
    @Test
    public void queryProcessor() throws IllegalAccessException {
        when(geoAPI.getTimeZoneId(51.28, 0.0)).thenReturn("Europe/London");

        String datetimePattern = "yyyy-MM-dd HH:mm:ss.SSS";

        User user = mock(User.class);
        when(user.getLatitude()).thenReturn(51.28);
        when(user.getLongitude()).thenReturn(0.0);
        Message message = spy(Message.class);
        when(message.getUser()).thenReturn(user);

        FieldUtils.writeDeclaredField(queryService, "datetimeformat", datetimePattern, true);

        Message outMessage = queryService.queryProcessor(message);

        String outDateTime = outMessage.getText();

        LocalDateTime localDateTime = LocalDateTime
            .parse(outDateTime, DateTimeFormatter.ofPattern(datetimePattern));
        message.setText(
            localDateTime.format(DateTimeFormatter.ofPattern(datetimePattern)));

        Assert.assertEquals(message, outMessage);
    }

}
