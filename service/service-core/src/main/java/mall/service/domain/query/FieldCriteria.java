package mall.service.domain.query;

import lombok.Getter;

/**
 * @author hongmiao.yu
 */
@Getter
public final class FieldCriteria implements Criteria {

    private final String fieldName;
    private final FieldOperator fieldOperator;
    private final Object value;

    FieldCriteria(String fieldName, FieldOperator fieldOperator, Object value) {
        this.fieldName = fieldName;
        this.fieldOperator = fieldOperator;
        this.value = value;
    }
}
