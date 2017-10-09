package com.instrumentisto.timebot.DTO;

import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link BaseDTO}.
 */
public class BaseDTOTest {

    /**
     * Test for {@code addValueOfField()} and {@code getValueOfField()} methods.
     * Here commits check about equality between object which stored as field
     * in DTO and object which was got from DTO.
     * Here is expects equality between stored and restored objects.
     */
    @Test
    public void testGetAndAddValueOfField() throws Exception {
        BaseDTO baseDTO = new BaseDTO();

        Assert.assertNull(baseDTO.getValueOfField("value1"));

        baseDTO.addValueOfField("field1", "value1");

        Assert.assertEquals("value1", baseDTO.getValueOfField("field1"));
    }

    /**
     * Test for {@code equals()} and {@code hashCode()} methods.
     */
    @Test
    public void testEqualsAndHashCode() throws Exception {
        BaseDTO baseDTO1 = new BaseDTO();
        BaseDTO baseDTO2 = new BaseDTO();

        Assert.assertTrue("Test equals() for clear objects",
            baseDTO1.equals(baseDTO2) && baseDTO2.equals(baseDTO1));
        Assert.assertTrue("Test hashCode() for clear objects",
            baseDTO1.hashCode() == baseDTO2.hashCode());

        baseDTO1.addValueOfField("field1", "value1");
        baseDTO2.addValueOfField("field1", "value1");

        Assert.assertTrue("Test equals() for identical objects",
            baseDTO1.equals(baseDTO2) && baseDTO2.equals(baseDTO1));
        Assert.assertTrue("Test hashCode() for identical objects",
            baseDTO1.hashCode() == baseDTO2.hashCode());

        baseDTO2.addValueOfField("field1", new Object());

        Assert.assertFalse("Test equals() for different objects",
            baseDTO1.equals(baseDTO2) && baseDTO2.equals(baseDTO1));
        Assert.assertFalse("Test hashCode() for different objects",
            baseDTO1.hashCode() == baseDTO2.hashCode());

        Assert.assertFalse("Test equals() for null", baseDTO1.equals(null));
        Assert.assertTrue(
            "Test equals() for the same object", baseDTO1.equals(baseDTO1));

        Field map = BaseDTO.class.getDeclaredField("map");
        boolean isAccessible = map.isAccessible();
        map.setAccessible(true);
        map.set(baseDTO1, null);
        map.setAccessible(isAccessible);

        Assert.assertEquals(
            "Test hashCode() for null map", 0, baseDTO1.hashCode());
    }
}
