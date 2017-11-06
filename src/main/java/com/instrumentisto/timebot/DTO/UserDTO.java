package com.instrumentisto.timebot.DTO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Describes DTO of {@link com.instrumentisto.timebot.entity.User}
 */
@Component
public class UserDTO {

    /**
     * User's ID in external API.
     */
    private String apiId;

    /**
     * Username of user.
     */
    @Autowired
    @Qualifier("getDefaultUsername")
    private String username;

    /**
     * User's location latitude.
     */
    @Autowired
    @Qualifier("getDefaultLatitude")
    private double latitude;

    /**
     * User's location longitude.
     */
    @Autowired
    @Qualifier("getDefaultLongitude")
    private double longitude;

    /**
     * Gets user's ID in API.
     *
     * @return {@link String} value.
     */
    public String getApiId() {
        return apiId;
    }

    /**
     * Sets user's ID in API.
     *
     * @param apiId value of ID which user has in API.
     */
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    /**
     * Gets name of user.
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
     * Gets user's location latitude.
     *
     * @return double value.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets user's location latitude.
     *
     * @param latitude user's location latitude.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets user's location longitude.
     *
     * @return double value.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets user's location longitude.
     *
     * @param longitude user's location latitude.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

        UserDTO userDTO = (UserDTO) o;

        return new EqualsBuilder()
            .append(apiId, userDTO.apiId)
            .append(username, userDTO.username)
            .append(latitude, userDTO.latitude)
            .append(longitude, userDTO.longitude)
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
