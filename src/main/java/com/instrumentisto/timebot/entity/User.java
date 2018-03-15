package com.instrumentisto.timebot.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Describes entity which presents user.
 */
@Data
@Entity
public class User {

    /**
     * User's ID local database.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * User's ID in external API.
     */
    @NotNull
    @Column(unique = true)
    private String apiId;

    /**
     * Username of user.
     */
    @NotNull
    @Autowired
    @Qualifier("getDefaultUsername")
    private String username;

    /**
     * User's location latitude.
     */
    @NotNull
    @Autowired
    @Qualifier("getDefaultLatitude")
    private double latitude;

    /**
     * User's location longitude.
     */
    @NotNull
    @Autowired
    @Qualifier("getDefaultLongitude")
    private double longitude;

    /**
     * User's messages.
     */
    @OneToMany
    private List<Message> messages;
}
