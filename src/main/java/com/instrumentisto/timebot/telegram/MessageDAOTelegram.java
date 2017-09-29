package com.instrumentisto.timebot.telegram;

import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.repository.MessageDAO;
import com.pengrad.telegrambot.TelegramBot;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDAOTelegram implements MessageDAO {

    @Autowired
    TelegramBot telegramBot;

    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public Message setMessage(Message message) {
        return null;
    }
}
