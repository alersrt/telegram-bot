package com.instrumentisto.timebot.telegram;

import com.instrumentisto.timebot.action.MessageActions;
import com.instrumentisto.timebot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceTelegram implements MessageService {

    @Autowired
    private MessageActions messageActions;

    @Value("${bot.timeout}")
    private long timeout;

    @Override
    public void updateService() {

    }

    @Override
    public void run() {

    }
}
