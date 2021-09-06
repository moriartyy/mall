package mall.infrastructure.repository.jpa.enums;

import mall.service.enums.Activity;

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
