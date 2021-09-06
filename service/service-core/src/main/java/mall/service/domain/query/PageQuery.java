package mall.service.domain.query;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public class PageQuery<T> implements Query<T, PageQueryResult<T>> {
    private final int pageIndex;
    private final int pageSize;
    private final Criteria criteria;
    private final Sort sort;

    private PageQuery(Builder<T> builder) {
        this.pageIndex = builder.pageIndex;
        this.pageSize = builder.pageSize;
        this.criteria = builder.criteria;
        this.sort = builder.sort;
    }

    public static <S> Builder<S> builder() {
        return new Builder<>();
    }

    public PageQueryResult.Builder<T> createResult() {
        return PageQueryResult.<T>builder().pageIndex(pageIndex).pageSize(pageSize);
    }

    public static class Builder<T> {
        private int pageIndex;
        private int pageSize;
        private Criteria criteria;
        private Sort sort;

        public Builder<T> pageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
            return this;
        }

        public Builder<T> pageSize(int pageSize) {
            this.pageSize = pageSize;
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

        public PageQuery<T> build() {
            return new PageQuery<>(this);
        }
    }
}
