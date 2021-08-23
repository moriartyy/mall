package mall.data.dictionary.service.infrastructure.mysql.repository;

import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResult;
import mall.data.dictionary.service.domain.Order;
import mall.data.dictionary.service.domain.OrderRepository;
import mall.data.dictionary.service.infrastructure.mysql.entity.OrderPO;
import mall.data.dictionary.service.infrastructure.mysql.mapper.OrderMapper;
import mall.infrastructure.mybatis.MybatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class MysqlOrderRepository extends MybatisRepository<Integer, Order, OrderPO> implements OrderRepository {

    @Autowired
    public MysqlOrderRepository(OrderMapper mapper) {
        super(mapper);
    }

    @Override
    public QueryResult<Order> query(Query query) {
        return null;
    }
}
