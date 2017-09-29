package com.instrumentisto.timebot.action;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

/**
 * This interface describes behavior of actions which commit under our basic entity {@link Message}.
 * Actions is short-lived terms which need for abstract business-logic from service.
 */
public interface MessageActions {

    /**
     * It returns list of messages which got from repository.
     *
     * @return {@link List<Message>}
     */
    List<Message> getMessages();

    /**
     * This method send message in recipient.
     *
     * @param message which need to send.
     * @return {@link Message} which was sent.
     */
    Message sendMessage(Message message);
}
