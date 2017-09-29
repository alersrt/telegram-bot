package com.instrumentisto.timebot.action;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

public interface MessageActions {
    List<Message> getMessages();
    Message sendMessage(Message message);
}
