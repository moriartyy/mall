package mall.data.dictionary.service.domain;

import mall.core.domain.Repository;
import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResult;

/**
 * @author walter
 */
public interface OrderRepository extends Repository<Integer, Order> {
    QueryResult<Order> query(Query query);
}
