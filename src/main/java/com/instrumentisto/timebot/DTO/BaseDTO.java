package com.instrumentisto.timebot.DTO;

import com.instrumentisto.timebot.exception.DTO.DTOFieldDoesNotExist;
import java.util.HashMap;
import java.util.Map;

/**
 * Describes DTO entity which will used for transfer API or {@link
 * com.instrumentisto.timebot.entity.Message} objects between Controller and
 * Handler layers.
 */
public class BaseDTO {

    /**
     * Storage which will to store fields of saved object and their values.
     */
    private Map<String, Object> map = new HashMap<>();

    /**
     * Adds field which must be save.
     *
     * @param fieldName name of saved object's field.
     * @param fieldValue value of saved object's field.
     */
    public void addValueOfField(String fieldName, Object fieldValue) {
        map.put(fieldName, fieldValue);
    }

    /**
     * Gets value of restored object from DTO.
     *
     * @param fieldName name of field which value have to get.
     * @return {@link Object} value.
     * @throws DTOFieldDoesNotExist commits during trying of getting nonexistent
     * field of DTO.
     */
    public Object getValueOfField(String fieldName)
        throws DTOFieldDoesNotExist {
        Object value = map.get(fieldName);

        if (value == null) {
            throw new DTOFieldDoesNotExist();
        }

        return value;
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

        BaseDTO baseDTO = (BaseDTO) o;

        return map != null ? map.equals(baseDTO.map) : baseDTO.map == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }
}
