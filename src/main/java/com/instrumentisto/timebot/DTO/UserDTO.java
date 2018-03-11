package com.instrumentisto.timebot.DTO;

import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Describes DTO of {@link com.instrumentisto.timebot.entity.User}
 */
@Data
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
}
