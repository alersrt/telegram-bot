package com.instrumentisto.timebot.DTO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link UserDTO}.
 */
public class UserDTOTest {

    /**
     * Object of tested class.
     */
    private UserDTO userDTO = new UserDTO();

    /**
     * Test getter for {@code apiId} field of {@link UserDTO}.
     *
     * Check assertion: returned value of apiId field must be equal to "1L".
     */
    @Test
    public void getApiId() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(userDTO, "apiId", "1L", true);

        Assert.assertEquals("1L", userDTO.getApiId());
    }

    /**
     * Test setter for {@code apiId} field of {@link UserDTO}.
     *
     * Check assertion: value of apiId field must be equal to "2L".
     */
    @Test
    public void setApiId() throws IllegalAccessException {
        userDTO.setApiId("2L");

        String apiIdValue = (String) FieldUtils
            .readDeclaredField(userDTO, "apiId", true);

        Assert.assertEquals("2L", apiIdValue);
    }

    /**
     * Test getter for {@code username} field of {@link UserDTO}.
     *
     * Check assertion: returned value of username field must be equal to
     * "tester".
     */
    @Test
    public void getUsername() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(userDTO, "username", "tester", true);

        Assert.assertEquals("tester", userDTO.getUsername());
    }

    /**
     * Test setter for {@code username} field of {@link UserDTO}.
     *
     * Check assertion: returned value of username field must be equal to
     * "newtester".
     */
    @Test
    public void setUsername() throws IllegalAccessException {
        userDTO.setUsername("newtester");

        String usernameValue = (String) FieldUtils
            .readDeclaredField(userDTO, "username", true);

        Assert.assertEquals("newtester", usernameValue);
    }

    /**
     * Test getter for {@code latitude} field of {@link UserDTO}.
     *
     * Check assertion: returned value of latitude field must be equal to 52.31.
     */
    @Test
    public void getLatitude() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(userDTO, "latitude", 52.31, true);

        Assert.assertEquals(52.31, userDTO.getLatitude(), 0.001);
    }

    /**
     * Test setter for {@code latitude} field of {@link UserDTO}.
     *
     * Check assertion: returned value of latitude field must be equal to 51.28.
     */
    @Test
    public void setLatitude() throws IllegalAccessException {
        userDTO.setLatitude(51.28);

        double latitudeValue = (double) FieldUtils
            .readDeclaredField(userDTO, "latitude", true);

        Assert.assertEquals(51.28, latitudeValue, 0.001);
    }

    /**
     * Test getter for {@code longitude} field of {@link UserDTO}.
     *
     * Check assertion: returned value of longitude field must be equal to 85.10.
     */
    @Test
    public void getLongitude() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(userDTO, "longitude", 85.10, true);

        Assert.assertEquals(85.10, userDTO.getLongitude(), 0.001);
    }

    /**
     * Test setter for {@code longitude} field of {@link UserDTO}.
     *
     * Check assertion: returned value of longitude field must be equal to 0.0.
     */
    @Test
    public void setLongitude() throws IllegalAccessException {
        userDTO.setLongitude(0.0);

        double longitudeValue = (double) FieldUtils
            .readDeclaredField(userDTO, "longitude", true);

        Assert.assertEquals(0.0, longitudeValue, 0.001);
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link UserDTO} equals to himself.
     */
    @Test
    public void equals_same_returnTrue() {
        Assert.assertTrue(userDTO.equals(userDTO));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link UserDTO} does not equal to object of another class.
     */
    @Test
    public void equals_anotherClass_returnFalse() {
        Assert.assertFalse(userDTO.equals(new Object()));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link UserDTO} objects with same apiId's are equals.
     */
    @Test
    public void equals_equalsFields_returnTrue() throws IllegalAccessException {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();

        FieldUtils.writeDeclaredField(userDTO1, "apiId", "1L", true);
        FieldUtils.writeDeclaredField(userDTO2, "apiId", "1L", true);

        Assert.assertTrue(userDTO1.equals(userDTO2));
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode of the same object is equal.
     */
    @Test
    public void hashCode_same_returnTrue() throws IllegalAccessException {
        UserDTO userDTO = new UserDTO();

        FieldUtils.writeDeclaredField(userDTO, "apiId", "1L", true);

        Assert.assertTrue(userDTO.hashCode() == userDTO.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode's for equal apiId's are equal.
     */
    public void hashCode_equalsFields_returnTrue()
        throws IllegalAccessException {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();

        FieldUtils.writeDeclaredField(userDTO1, "apiId", "1L", true);
        FieldUtils.writeDeclaredField(userDTO2, "apiId", "1L", true);

        Assert.assertTrue(userDTO1.hashCode() == userDTO2.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode's for different apiId's are not equal.
     */
    public void hashCode_differentFields_returnFalse()
        throws IllegalAccessException {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();

        FieldUtils.writeDeclaredField(userDTO1, "apiId", "1L", true);
        FieldUtils.writeDeclaredField(userDTO2, "apiId", "2L", true);

        Assert.assertFalse(userDTO1.hashCode() == userDTO2.hashCode());
    }
}
