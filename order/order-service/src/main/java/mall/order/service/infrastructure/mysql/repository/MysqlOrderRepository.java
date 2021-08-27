package mall.order.service.infrastructure.mysql.repository;

import mall.infrastructure.mybatis.MybatisRepository;
import mall.order.service.domain.Order;
import mall.order.service.domain.OrderRepository;
import mall.order.service.infrastructure.mysql.entity.OrderPO;
import mall.order.service.infrastructure.mysql.mapper.OrderMapper;
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
}