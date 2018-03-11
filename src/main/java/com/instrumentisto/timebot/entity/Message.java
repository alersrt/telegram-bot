package com.instrumentisto.timebot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Describes entity which presents bot's message.
 */
@Data
@Entity
public class Message {

    /**
     * ID field which will used for work with database.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Text field which contains text of message.
     */
    @NotNull
    private String text;

    /**
     * Field which contains ID of recipient.
     */
    @NotNull
    private String chatId;

    /**
     * Field which contains {@link User} to which this message belongs.
     */
    @NotNull
    @ManyToOne
    private User user;
}
