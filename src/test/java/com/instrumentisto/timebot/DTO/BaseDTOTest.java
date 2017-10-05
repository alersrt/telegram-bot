package com.instrumentisto.timebot.DTO;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link BaseDTO}.
 */
public class BaseDTOTest {

    /**
     * Test for {@code addValueOfField()} and {@code getValueOfField()} methods.
     */
    @Test
    public void testGetAndAddValueOfField() throws Exception {
        BaseDTO baseDTO = new BaseDTO();

        Assert.assertNull(baseDTO.getValueOfField("value1"));

        baseDTO.addValueOfField("field1", "value1");

        Assert.assertEquals("value1", baseDTO.getValueOfField("field1"));
    }
}
