package mall.service.domain.query;

import java.util.List;

/**
 * @author walter
 */
public interface QueryResult<T> {
    List<T> getItems();
}
