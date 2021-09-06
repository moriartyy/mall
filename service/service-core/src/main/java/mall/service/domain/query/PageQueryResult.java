package mall.service.domain.query;

import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * @author walter
 */
@Getter
public class PageQueryResult<T> implements QueryResult<T> {
    private final List<T> items;
    private final long totalItems;
    private final long totalPages;
    private final long pageIndex;
    private final long pageSize;

    private PageQueryResult(Builder<T> builder) {
        this.items = ImmutableList.copyOf(builder.items);
        this.totalItems = builder.totalItems;
        this.totalPages = builder.totalPages;
        this.pageIndex = builder.pageIndex;
        this.pageSize = builder.pageSize;

    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private List<T> items = Collections.emptyList();
        private long totalItems;
        private long totalPages;
        private long pageIndex;
        private long pageSize;

        public Builder<T> items(List<T> items) {
            this.items = items;
            return this;
        }

        public Builder<T> totalItems(long totalItems) {
            this.totalItems = totalItems;
            return this;
        }

        public Builder<T> totalPages(long totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder<T> pageIndex(long pageIndex) {
            this.pageIndex = pageIndex;
            return this;
        }

        public Builder<T> pageSize(long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PageQueryResult<T> build() {
            return new PageQueryResult<>(this);
        }

    }
}
