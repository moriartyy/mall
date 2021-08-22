package mall.data.dictionary.service.infrastructure.mysql.repository;

import mall.data.dictionary.service.domain.Order;
import mall.data.dictionary.service.domain.OrderRepository;
import mall.data.dictionary.service.infrastructure.mysql.entity.OrderPO;
import mall.data.dictionary.service.infrastructure.mysql.mapper.OrderMapper;
import mall.data.dictionary.service.infrastructure.mysql.translator.OrderTranslator;
import mall.infrastructure.mybatis.MybatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class MysqlOrderRepository extends MybatisRepository<Integer, Order, OrderPO> implements OrderRepository {

    @Autowired
    public MysqlOrderRepository(OrderMapper mapper, OrderTranslator translator) {
        super(mapper, translator);
    }
}
