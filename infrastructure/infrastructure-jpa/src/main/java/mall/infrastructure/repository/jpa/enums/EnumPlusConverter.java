package mall.infrastructure.repository.jpa.enums;

import mall.service.enums.EnumPlus;
import mall.service.util.EnumUtils;

import javax.persistence.AttributeConverter;

/**
 * @author walter
 */
public abstract class EnumPlusConverter<T extends Enum<T> & EnumPlus> implements AttributeConverter<T, Integer> {

    private final Class<T> enumType;

    protected EnumPlusConverter(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public Integer convertToDatabaseColumn(T attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public T convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return EnumUtils.getByValue(enumType, dbData);
    }
}
