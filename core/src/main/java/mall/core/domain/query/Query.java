package mall.core.domain.query;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public class Query {
    private long offset;
    private long limit;
    private Criteria criteria;
    private Sort sort;

    private Query(Builder builder) {
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.criteria = builder.criteria;
        this.sort = builder.sort;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long offset;
        private long limit;
        private Criteria criteria;
        private Sort sort;

        public Builder offset(long offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(long limit) {
            this.limit = limit;
            return this;
        }

        public Builder criteria(Criteria criteria) {
            this.criteria = criteria;
            return this;
        }

        public Builder sort(Sort sort) {
            this.sort = sort;
            return this;
        }

        public Query build() {
            return new Query(this);
        }
    }
}
