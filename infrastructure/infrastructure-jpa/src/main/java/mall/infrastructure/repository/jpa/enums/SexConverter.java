package mall.infrastructure.repository.jpa.enums;

import mall.common.enums.Sex;

import javax.persistence.Converter;

/**
 * @author walter
 */
@Converter(autoApply = true)
public class SexConverter extends EnumPlusConverter<Sex> {

    public SexConverter() {
        super(Sex.class);
    }
}
