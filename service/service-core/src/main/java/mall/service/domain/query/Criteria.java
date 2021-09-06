package mall.service.domain.query;

import java.util.List;
import java.util.Objects;

import static mall.service.domain.query.FieldOperator.*;

/**
 * @author hongmiao.yu
 */
public interface Criteria {

    default boolean isEmpty() {
        return false;
    }

    default Criteria and(Criteria other) {
        return this.isEmpty() ? other : new AndCriteria(this, other);
    }

    default Criteria or(Criteria other) {
        return this.isEmpty() ? other : new OrCriteria(this, other);
    }

    Criteria EMPTY = new Criteria() {
        @Override
        public boolean isEmpty() {
            return true;
        }
    };

    default Criteria trim() {
        return trim(this);
    }

    static Criteria trim(Criteria c) {
        if (c.isEmpty()) {
            return c;
        } else if (c instanceof FieldCriteria) {
            FieldCriteria fc = (FieldCriteria) c;
            return Objects.isNull(fc.getValue()) ? EMPTY : fc;
        } else if (c instanceof AndCriteria) {
            AndCriteria ac = (AndCriteria) c;
            return trim(ac.getLeft()).and(trim(ac.getRight()));
        } else if (c instanceof OrCriteria) {
            OrCriteria oc = (OrCriteria) c;
            return trim(oc.getLeft()).or(trim(oc.getRight()));
        } else {
            throw new IllegalStateException("Unsupported Criteria: " + c.getClass());
        }
    }

    static Criteria of() {
        return EMPTY;
    }

    static Criteria of(String field, FieldOperator operator, Object value) {
        return new FieldCriteria(field, operator, value);
    }

    static Criteria equalTo(String field, Object value) {
        return of(field, EQ, value);
    }

    static Criteria notEqualTo(String field, Object value) {
        return of(field, NE, value);
    }

    static Criteria greaterThen(String field, Object value) {
        return of(field, GT, value);
    }

    static Criteria greaterThanOrEqualTo(String field, Object value) {
        return of(field, GTE, value);
    }

    static Criteria lessThan(String field, Object value) {
        return of(field, LT, value);
    }

    static Criteria lessThanOrEqualTo(String field, Object value) {
        return of(field, LTE, value);
    }

    static Criteria contains(String field, String value) {
        return of(field, CN, value);
    }

    static Criteria startWith(String field, String value) {
        return of(field, SW, value);
    }

    static Criteria endWith(String field, String value) {
        return of(field, EW, value);
    }

    static Criteria in(String field, List<?> values) {
        return of(field, IN, values);
    }

    static Criteria notIn(String field, List<?> values) {
        return of(field, NIN, values);
    }
}
