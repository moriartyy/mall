package mall.dictionary.service.infrastructure.mysql.repository;

import mall.dictionary.service.domain.Order;
import mall.dictionary.service.domain.OrderRepository;
import mall.dictionary.service.infrastructure.mysql.entity.OrderPO;
import mall.dictionary.service.infrastructure.mysql.mapper.OrderMapper;
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
}
