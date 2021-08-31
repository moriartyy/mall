package mall.core.domain.query;

import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * @author walter
 */
@Getter
public class QueryResult<T> {
    private final List<T> items;
    private final long total;

    private QueryResult(Builder<T> builder) {
        this.items = ImmutableList.copyOf(builder.items);
        this.total = builder.total;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private List<T> items = Collections.emptyList();
        private long total;

        public Builder<T> items(List<T> items) {
            this.items = items;
            return this;
        }

        public Builder<T> total(long total) {
            this.total = total;
            return this;
        }

        public QueryResult<T> build() {
            return new QueryResult<>(this);
        }

    }
}
