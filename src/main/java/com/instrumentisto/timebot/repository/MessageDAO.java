package com.instrumentisto.timebot.repository;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

public interface MessageDAO {
    List<Message> getMessages();
    Message setMessage(Message message);
}
