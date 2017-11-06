package com.instrumentisto.timebot.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Describes entity which presents user.
 */
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

    /**
     * Gets ID of User in database.
     *
     * @return int value.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets ID of User in database.
     *
     * @param id ID which need to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets ID of User in API.
     *
     * @return {@link String} value.
     */
    public String getApiId() {
        return apiId;
    }

    /**
     * Sets ID of User in external API.
     *
     * @param apiId ID which need to set in external API.
     */
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    /**
     * Gets name of User.
     *
     * @return {@link String} value.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets name of User.
     *
     * @param username name to which need to set username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets user's location in array of two elements: [latitude, longitude].
     *
     * @return double[] value.
     */
    public double[] getLocation() {
        return new double[]{this.latitude, this.longitude};
    }

    /**
     * Sets user location.
     *
     * @param latitude user's location latitude.
     * @param longitude users's location longitude.
     */
    public void setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets user's messages.
     *
     * @return {@link List} of {@link Message}.
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Sets user's messages.
     *
     * @param messages list of messages.
     */
    public void setMessages(
        List<Message> messages) {
        this.messages = messages;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return new EqualsBuilder()
            .append(latitude, user.latitude)
            .append(longitude, user.longitude)
            .append(apiId, user.apiId)
            .append(username, user.username)
            .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(apiId)
            .append(username)
            .append(latitude)
            .append(longitude)
            .toHashCode();
    }
}
