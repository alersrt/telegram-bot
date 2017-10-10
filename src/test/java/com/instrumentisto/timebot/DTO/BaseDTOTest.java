package com.instrumentisto.timebot.DTO;

import com.instrumentisto.timebot.exception.DTO.DTOFieldDoesNotExist;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit-test for {@link BaseDTO}.
 */
public class BaseDTOTest {

    /**
     * Test for {@code addValueOfField()} and {@code getValueOfField()} methods.
     *
     * Checks assertions:
     * 1. In case of trying unsaved object's getting, {@link DTOFieldDoesNotExist}
     * exception must be thrown;
     * 2. Restored object must equals to stored.
     */
    @Test
    public void testGetAndAddValueOfField() throws Exception {
        BaseDTO baseDTO = new BaseDTO();

        try {
            Assert.assertNull(baseDTO.getValueOfField("value1"));
        } catch (Exception e) {
            Assert.assertEquals(DTOFieldDoesNotExist.class, e.getClass());
        }

        baseDTO.addValueOfField("field1", "value1");

        Assert.assertEquals("value1", baseDTO.getValueOfField("field1"));
    }

    /**
     * Test for {@code equals()} and {@code hashCode()} methods of {@link
     * BaseDTO}.
     *
     * Checks assertions:
     * 1. Clear objects must be equals;
     * 2. Hashcodes of clear objects must be equals;
     * 3. Identical objects must be equals;
     * 4. Hashcodes of identical objects must be equals;
     * 5. Different objects must not be equals;
     * 6. Hashcode of different objects must not be equals;
     * 7. Object must not be equals to {@code null};
     * 8. Object must be equals to itselve;
     * 9. Hashcode of object for in case when inner map equals to {@code null},
     * must be equal to 0.
     */
    @Test
    public void testEqualsAndHashCode() throws Exception {
        BaseDTO baseDTO1 = new BaseDTO();
        BaseDTO baseDTO2 = new BaseDTO();

        Assert.assertTrue(
            "Test equals() for clear objects",
            baseDTO1.equals(baseDTO2) && baseDTO2.equals(baseDTO1));
        Assert.assertTrue(
            "Test hashCode() for clear objects",
            baseDTO1.hashCode() == baseDTO2.hashCode());

        baseDTO1.addValueOfField("field1", "value1");
        baseDTO2.addValueOfField("field1", "value1");

        Assert.assertTrue(
            "Test equals() for identical objects",
            baseDTO1.equals(baseDTO2) && baseDTO2.equals(baseDTO1));
        Assert.assertTrue(
            "Test hashCode() for identical objects",
            baseDTO1.hashCode() == baseDTO2.hashCode());

        baseDTO2.addValueOfField("field1", new Object());

        Assert.assertFalse(
            "Test equals() for different objects",
            baseDTO1.equals(baseDTO2) && baseDTO2.equals(baseDTO1));
        Assert.assertFalse(
            "Test hashCode() for different objects",
            baseDTO1.hashCode() == baseDTO2.hashCode());

        Assert.assertFalse("Test equals() for null", baseDTO1.equals(null));
        Assert.assertTrue("Test equals() for the same object",
            baseDTO1.equals(baseDTO1));

        Field map = BaseDTO.class.getDeclaredField("map");
        boolean isAccessible = map.isAccessible();
        map.setAccessible(true);
        map.set(baseDTO1, null);
        map.setAccessible(isAccessible);

        Assert.assertEquals("Test hashCode() for null map", 0,
            baseDTO1.hashCode());
    }
}
