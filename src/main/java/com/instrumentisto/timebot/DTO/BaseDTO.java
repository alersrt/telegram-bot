package com.instrumentisto.timebot.DTO;

import java.util.HashMap;
import java.util.Map;

/**
 * The class describes DTO entity which will used for transfer API or {@link
 * com.instrumentisto.timebot.entity.Message} objects between Controller and Handler layers.
 */
public class BaseDTO {

    /**
     * Storage which will to store fields of saved object and their values.
     */
    private Map<String, String> map = new HashMap<>();

    /**
     * Adds field which must be save.
     *
     * @param fieldName name of saved object's field.
     * @param fieldValue value of saved object's field.
     */
    public void addValueOfField(String fieldName, String fieldValue) {
        map.put(fieldName, fieldValue);
    }

    /**
     * Gets value of restored object from DTO.
     *
     * @param fieldName name of field which value have to get.
     * @return {@link String} value.
     */
    public String getValueOfField(String fieldName) {
        return map.get(fieldName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseDTO baseDTO = (BaseDTO) o;

        return map != null ? map.equals(baseDTO.map) : baseDTO.map == null;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }
}
