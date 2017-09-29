package com.instrumentisto.timebot.repository;

import com.instrumentisto.timebot.entity.Message;
import java.util.List;

/**
 * It is interface which describes of message repository. The main goal existence of this interface
 * is describing of message repository's behavior. Converting of types happens here: at the enter we
 * add Message which converts in types of some API or conversely it returns Message which got from
 * the same API.
 */
public interface MessageDAO {

    /**
     * This method returns {@link List<Message>} of updates which got from API. Also this method is
     * providing type conversion: API's types is converted in our message type.
     */
    List<Message> getMessages();

    /**
     * This method transfers message to API. Also this method converts our message in the API's type.
     *
     * @param message is message which need to transfer to API.
     * @return message which was transferred to API.
     */
    Message setMessage(Message message);
}
