package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.dictionary.service.enums.SortOrder;
import mall.service.domain.AuditableEntity;
import mall.service.enums.Activity;

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
