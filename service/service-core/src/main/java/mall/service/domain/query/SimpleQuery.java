package mall.service.domain.query;

import lombok.Getter;

import java.util.List;

/**
 * @author walter
 */
@Getter
public class SimpleQuery<T> implements Query<T, List<T>> {
    private final int limit;
    private final Criteria criteria;
    private final Sort sort;

    private SimpleQuery(Builder<T> builder) {
        this.limit = builder.limit;
        this.criteria = builder.criteria;
        this.sort = builder.sort;
    }

    public static <S> Builder<S> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private int limit;
        private Criteria criteria;
        private Sort sort;

        public Builder<T> limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder<T> criteria(Criteria criteria) {
            this.criteria = criteria;
            return this;
        }

        public Builder<T> sort(Sort sort) {
            this.sort = sort;
            return this;
        }

        public SimpleQuery<T> build() {
            return new SimpleQuery<>(this);
        }
    }
}
