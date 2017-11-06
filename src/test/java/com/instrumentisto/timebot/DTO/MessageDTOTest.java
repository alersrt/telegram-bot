package com.instrumentisto.timebot.DTO;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link MessageDTO}.
 */
public class MessageDTOTest {

    /**
     * Object of tested class.
     */
    private MessageDTO messageDTO = new MessageDTO();

    /**
     * Test getter for {@code chatId} field of {@link MessageDTO}.
     *
     * Check assertion: returned value of chatId field must be equal to "1L".
     */
    @Test
    public void getChatId() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(messageDTO, "chatId", "1L", true);

        Assert.assertEquals("1L", messageDTO.getChatId());
    }

    /**
     * Test setter for {@code chatId} field of {@link MessageDTO}.
     *
     * Check assertion: value of chatId field must be equal to "2L".
     */
    @Test
    public void setChatId() throws IllegalAccessException {
        messageDTO.setChatId("2L");

        String chatIdValue = (String) FieldUtils
            .readDeclaredField(messageDTO, "chatId", true);

        Assert.assertEquals("2L", chatIdValue);
    }

    /**
     * Test getter for {@code text} field of {@link MessageDTO}.
     *
     * Check assertion: returned value of text field must be equal to "getter
     * test".
     */
    @Test
    public void getText() throws IllegalAccessException {
        FieldUtils.writeDeclaredField(messageDTO, "text", "getter test", true);

        Assert.assertEquals("getter test", messageDTO.getText());
    }

    /**
     * Test setter for {@code text} field of {@link MessageDTO}.
     *
     * Check assertion: value of text field must be equal to "setter test".
     */
    @Test
    public void setText() throws IllegalAccessException {
        messageDTO.setText("setter test");

        String textValue = (String) FieldUtils
            .readDeclaredField(messageDTO, "text", true);

        Assert.assertEquals("setter test", textValue);
    }

    /**
     * Test getter for {@code userDTO} field of {@link MessageDTO}.
     *
     * Check assertion: returned {@link UserDTO} object must be equal to mocked
     * object.
     */
    @Test
    public void getUserDTO() throws IllegalAccessException {
        UserDTO userDTO = mock(UserDTO.class);

        FieldUtils.writeDeclaredField(messageDTO, "userDTO", userDTO, true);

        Assert.assertEquals(userDTO, messageDTO.getUserDTO());
    }

    /**
     * Test setter for {@code text} field of {@link MessageDTO}.
     *
     * Check assertion: value of text field must be equal to "setter test".
     */
    @Test
    public void setUserDTO() throws IllegalAccessException {
        UserDTO userDTO = mock(UserDTO.class);

        messageDTO.setUserDTO(userDTO);

        UserDTO userDTOValue = (UserDTO) FieldUtils
            .readDeclaredField(messageDTO, "userDTO", true);

        Assert.assertEquals(userDTO, userDTOValue);
    }

    /**
     * Test getter for {@code isLocationDefault} field.
     *
     * Check assertion: returned value of isLocationDefault field must be equals
     * to true.
     */
    @Test
    public void isLocationDefault() throws IllegalAccessException {
        FieldUtils
            .writeDeclaredField(messageDTO, "isLocationDefault", true, true);

        Assert.assertTrue(messageDTO.isLocationDefault());
    }

    /**
     * Test setter for {@code isLocationDefault} field.
     *
     * Check assertion: value of isLocationDefault field must be equals to false.
     */
    @Test
    public void setLocationDefault() throws IllegalAccessException {
        messageDTO.setLocationDefault(false);

        boolean isLocationDefaultValue = (boolean) FieldUtils
            .readDeclaredField(messageDTO, "isLocationDefault", true);

        Assert.assertFalse(isLocationDefaultValue);
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link MessageDTO} equals to himself.
     */
    @Test
    public void equals_same_returnTrue() {
        Assert.assertTrue(messageDTO.equals(messageDTO));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link MessageDTO} does not equal to object of another
     * class.
     */
    @Test
    public void equals_anotherClass_returnFalse() {
        Assert.assertFalse(messageDTO.equals(new Object()));
    }

    /**
     * Test equals() method.
     *
     * Check assertion: {@link MessageDTO} does not equal to object whose fields
     * has another values.
     */
    @Test
    public void equals_another_returnFalse() throws IllegalAccessException {
        MessageDTO messageDTO1 = new MessageDTO();
        MessageDTO messageDTO2 = new MessageDTO();

        UserDTO userDTO1 = mock(UserDTO.class);
        when(userDTO1.getApiId()).thenReturn("1L");
        UserDTO userDTO2 = mock(UserDTO.class);
        when(userDTO2.getApiId()).thenReturn("2L");

        FieldUtils.writeDeclaredField(messageDTO1, "chatId", "1L", true);
        FieldUtils.writeDeclaredField(messageDTO1, "text", "first text", true);
        FieldUtils.writeDeclaredField(messageDTO1, "userDTO", userDTO1, true);

        FieldUtils.writeDeclaredField(messageDTO2, "chatId", "2L", true);
        FieldUtils.writeDeclaredField(messageDTO2, "text", "second text", true);
        FieldUtils.writeDeclaredField(messageDTO2, "userDTO", userDTO2, true);

        Assert.assertFalse(messageDTO1.equals(messageDTO2));
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode() of {@link MessageDTO} equals to himself's
     * hashCode().
     */
    @Test
    public void hashCode_same_returnTrue() {
        Assert.assertTrue(messageDTO.hashCode() == messageDTO.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode() of {@link MessageDTO} equals to hashCode() of
     * object which has the same values of fields.
     */
    @Test
    public void hashCode_equaledFields_returnTrue()
        throws IllegalAccessException {
        MessageDTO messageDTO1 = new MessageDTO();
        MessageDTO messageDTO2 = new MessageDTO();

        UserDTO userDTO1 = mock(UserDTO.class);
        when(userDTO1.getApiId()).thenReturn("1L");

        FieldUtils.writeDeclaredField(messageDTO1, "chatId", "1L", true);
        FieldUtils.writeDeclaredField(messageDTO1, "text", "first text", true);
        FieldUtils.writeDeclaredField(messageDTO1, "userDTO", userDTO1, true);

        FieldUtils.writeDeclaredField(messageDTO2, "chatId", "1L", true);
        FieldUtils.writeDeclaredField(messageDTO2, "text", "first text", true);
        FieldUtils.writeDeclaredField(messageDTO2, "userDTO", userDTO1, true);

        Assert.assertTrue(messageDTO1.hashCode() == messageDTO2.hashCode());
    }

    /**
     * Test hashCode() method.
     *
     * Check assertion: hashCode() of {@link MessageDTO} does not equal to
     * hashCode() of object which fields has another values.
     */
    @Test
    public void hashCode_differentFields_returnFalse()
        throws IllegalAccessException {
        MessageDTO messageDTO1 = new MessageDTO();
        MessageDTO messageDTO2 = new MessageDTO();

        UserDTO userDTO1 = mock(UserDTO.class);
        when(userDTO1.getApiId()).thenReturn("1L");
        UserDTO userDTO2 = mock(UserDTO.class);
        when(userDTO2.getApiId()).thenReturn("2L");

        FieldUtils.writeDeclaredField(messageDTO1, "chatId", "1L", true);
        FieldUtils.writeDeclaredField(messageDTO1, "text", "first text", true);
        FieldUtils.writeDeclaredField(messageDTO1, "userDTO", userDTO1, true);

        FieldUtils.writeDeclaredField(messageDTO2, "chatId", "2L", true);
        FieldUtils.writeDeclaredField(messageDTO2, "text", "second text", true);
        FieldUtils.writeDeclaredField(messageDTO2, "userDTO", userDTO2, true);

        Assert.assertFalse(messageDTO1.hashCode() == messageDTO2.hashCode());
    }
}
