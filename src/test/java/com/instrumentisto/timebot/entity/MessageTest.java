package com.instrumentisto.timebot.entity;

import org.junit.Before;
import org.junit.Test;

public class MessageTest {

    private Message message1;
    private Message message2;

    @Before
    public void setUp() throws Exception {
        message1 = new Message();
        message2 = new Message();

        message1.setId(1);
        message1.setText("It is the simple text.");
        message1.setChatId("1L");

        message2.setId(2);
        message2.setText("So, this is some text.");
        message2.setChatId("2L");
    }

    @Test
    public void getId() throws Exception {
    }

    @Test
    public void setId() throws Exception {
    }

    @Test
    public void getText() throws Exception {
    }

    @Test
    public void setText() throws Exception {
    }

    @Test
    public void getChatId() throws Exception {
    }

    @Test
    public void setChatId() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }

    @Test
    public int hashCode() {
        return 0;
    }

}
