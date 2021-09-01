package mall.infrastructure.repository.jpa.enums;

import mall.common.enums.Activity;

import javax.persistence.Converter;

/**
 * @author walter
 */
@Converter(autoApply = true)
public class ActivityConverter extends EnumPlusConverter<Activity> {

    public ActivityConverter() {
        super(Activity.class);
    }
}
