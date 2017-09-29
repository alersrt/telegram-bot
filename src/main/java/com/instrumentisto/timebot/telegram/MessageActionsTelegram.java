package com.instrumentisto.timebot.telegram;

import com.instrumentisto.timebot.action.MessageActions;
import com.instrumentisto.timebot.entity.Message;
import com.instrumentisto.timebot.repository.MessageDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageActionsTelegram implements MessageActions {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public List<Message> getMessages() {
        //TODO: need realize this method
        return null;
    }

    @Override
    public Message sendMessage(Message message) {
        //TODO: need realize this method
        return null;
    }
}
