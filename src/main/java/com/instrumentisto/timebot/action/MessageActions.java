package com.instrumentisto.timebot.action;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

/**
 * Describes behavior of actions which commit under our basic entity {@link Message}.
 * Actions is short-lived terms which need for abstract business-logic from service.
 */
public interface MessageActions {

    /**
     * Returns list of messages which got from repository.
     *
     * @return {@link List<Message>}
     */
    List<Message> getMessages();

    /**
     * Sends message to recipient.
     *
     * @param message which need to send.
     * @return {@link Message} which was sent.
     */
    Message sendMessage(Message message);
}
