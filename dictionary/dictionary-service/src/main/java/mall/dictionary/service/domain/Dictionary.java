package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.common.enums.Activity;
import mall.core.domain.AuditableEntity;
import mall.dictionary.api.enums.SortOrder;

/**
 * @author Walter
 */
@Getter
@Setter
public class Dictionary extends AuditableEntity<Integer> {

    private String code;
    private String description;
    private Activity activity;
    private SortOrder sortOrder;

}
