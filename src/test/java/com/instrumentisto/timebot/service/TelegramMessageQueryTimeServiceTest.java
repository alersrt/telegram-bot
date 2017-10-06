package com.instrumentisto.timebot.service;

import com.instrumentisto.timebot.entity.Message;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link TelegramMessageQueryTimeService}.
 */
public class TelegramMessageQueryTimeServiceTest {

    /**
     * Test for {@code queryProcessor({@link com.instrumentisto.timebot.entity.Message message})}
     * method. Here is expects difference between input message and this method's answer. Also text of
     * output message must contains date to which will set text in the tested method.
     */
    @Test
    public void queryProcessor() throws Exception {
        TelegramMessageQueryTimeService timeService = new TelegramMessageQueryTimeService();

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
        message.setText(localDateTime.format(DateTimeFormatter.ofPattern(datetimePattern)));

        Assert.assertNotNull(outMessage);
        Assert.assertEquals(message, outMessage);
    }
}
