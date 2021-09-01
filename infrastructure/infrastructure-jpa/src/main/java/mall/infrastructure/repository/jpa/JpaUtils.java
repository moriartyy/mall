package mall.infrastructure.repository.jpa;

import mall.core.domain.query.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author walter
 */
public class JpaUtils {

    public static Sort resolveSort(SimpleQuery<?> query) {
        return Sort.by(query.getSort().getOrders().stream()
                .map(o -> new Sort.Order(o.isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC, o.getFieldName()))
                .collect(Collectors.toList())
        );
    }

    public static <PO> Specification<PO> resolveSpecification(SimpleQuery<?> query) {
        return (r, q, b) -> toPredicate(query.getCriteria(), b, r);
    }

    public static Predicate toPredicate(Criteria criteria, CriteriaBuilder builder, Root<?> root) {
        if (criteria instanceof FieldCriteria) {
            return toPredicate((FieldCriteria) criteria, builder, root);
        } else if (criteria instanceof AndCriteria) {
            AndCriteria c = (AndCriteria) criteria;
            return builder.and(toPredicate(c.getLeft(), builder, root), toPredicate(c.getRight(), builder, root));
        } else if (criteria instanceof OrCriteria) {
            OrCriteria c = (OrCriteria) criteria;
            return builder.or(toPredicate(c.getLeft(), builder, root), toPredicate(c.getRight(), builder, root));
        } else {
            throw new IllegalStateException("Unsupported Criteria: " + criteria.getClass());
        }
    }

    public static Predicate toPredicate(FieldCriteria criteria, CriteriaBuilder builder, Root<?> root) {
        String fieldName = criteria.getFieldName();
        Object value = criteria.getValue();
        switch (criteria.getFieldOperator()) {
            case EQ:
                return builder.equal(root.get(fieldName), value);
            case NE:
                return builder.notEqual(root.get(fieldName), value);
            case LT:
                return builder.lt(root.get(fieldName), (Number) value);
            case LTE:
                return builder.le(root.get(fieldName), (Number) value);
            case GT:
                return builder.gt(root.get(fieldName), (Number) value);
            case GTE:
                return builder.ge(root.get(fieldName), (Number) value);
            case SW:
                return builder.like(root.get(fieldName), value + ".%");
            case EW:
                return builder.like(root.get(fieldName), "%" + value);
            case CN:
                return builder.like(root.get(fieldName), "%" + value + "%");
            case IN:
                return buildInPredicate(fieldName, (List<?>) value, builder, root);
            case NIN:
                return builder.not(buildInPredicate(fieldName, (List<?>) value, builder, root));
            default:
                throw new IllegalArgumentException("Unsupported FieldOperator: " + criteria.getFieldOperator().name());
        }
    }

    private static Predicate buildInPredicate(String fieldName, List<?> values, CriteriaBuilder builder, Root<?> root) {
        CriteriaBuilder.In<Object> in = builder.in(root.get(fieldName));
        for (Object value : values) {
            in.value(value);
        }
        return in;
    }

}
