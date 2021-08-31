package mall.core.domain.query;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public class RawQuery<T> implements Query<T> {

    private final String sql;

    public RawQuery(String sql) {
        this.sql = sql;
    }
}
