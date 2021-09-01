package mall.infrastructure.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mall.core.domain.query.*;

import java.util.List;
import java.util.Map;

/**
 * @author walter
 */
public class MybatisUtils {

    public static <T> void fillSort(QueryWrapper<T> queryWrapper, Sort sort, Map<String, String> fieldToColumnMap) {
        sort.forEach(order -> {
            String columnName = fieldToColumnMap.get(order.getFieldName());
            if (order.getDirection() == Sort.Direction.ASC) {
                queryWrapper.orderByAsc(columnName);
            } else {
                queryWrapper.orderByDesc(columnName);
            }
        });
    }

    public static <T> QueryWrapper<T> fillWithCriteria(QueryWrapper<T> queryWrapper, Criteria criteria, Map<String, String> fieldToColumnMap) {
        if (criteria instanceof FieldCriteria) {
            return fillWithCriteria(queryWrapper, (FieldCriteria) criteria, fieldToColumnMap);
        } else if (criteria instanceof AndCriteria) {
            AndCriteria ac = (AndCriteria) criteria;
            return fillWithCriteria(queryWrapper, ac.getLeft(), fieldToColumnMap).and(w -> fillWithCriteria(queryWrapper, ac.getRight(), fieldToColumnMap));
        } else if (criteria instanceof OrCriteria) {
            OrCriteria oc = (OrCriteria) criteria;
            return fillWithCriteria(queryWrapper, oc.getLeft(), fieldToColumnMap).or(w -> fillWithCriteria(queryWrapper, oc.getRight(), fieldToColumnMap));
        } else {
            throw new IllegalStateException("Unsupported Criteria: " + criteria.getClass());
        }
    }

    public static <T> QueryWrapper<T> fillWithCriteria(QueryWrapper<T> queryWrapper, FieldCriteria criteria, Map<String, String> fieldToColumnMap) {
        String columnName = fieldToColumnMap.get(criteria.getFieldName());
        switch (criteria.getFieldOperator()) {
            case EQ:
                return queryWrapper.eq(columnName, criteria.getValue());
            case NE:
                return queryWrapper.ne(columnName, criteria.getValue());
            case LT:
                return queryWrapper.lt(columnName, criteria.getValue());
            case LTE:
                return queryWrapper.le(columnName, criteria.getValue());
            case GT:
                return queryWrapper.gt(columnName, criteria.getValue());
            case GTE:
                return queryWrapper.ge(columnName, criteria.getValue());
            case SW:
                return queryWrapper.likeLeft(columnName, criteria.getValue() + ".%");
            case EW:
                return queryWrapper.likeRight(columnName, "%" + criteria.getValue());
            case CN:
                return queryWrapper.like(columnName, "%" + criteria.getValue() + "%");
            case IN:
                return queryWrapper.in(columnName, (List<?>) criteria.getValue());
            case NIN:
                return queryWrapper.notIn(columnName, (List<?>) criteria.getValue());
            default:
                throw new IllegalArgumentException("Unsupported FieldOperator: " + criteria.getFieldOperator().name());
        }
    }

}
