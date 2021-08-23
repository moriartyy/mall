package mall.core.domain.query;

import lombok.Getter;

/**
 * @author hongmiao.yu
 */
@Getter
public final class OrCriteria implements Criteria {

    private Criteria left;
    private Criteria right;

    OrCriteria(Criteria left, Criteria right) {
        this.left = left;
        this.right = right;
    }

}
