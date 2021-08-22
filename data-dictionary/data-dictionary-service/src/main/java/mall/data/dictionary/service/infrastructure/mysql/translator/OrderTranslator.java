package mall.data.dictionary.service.infrastructure.mysql.translator;

import mall.core.infrastructure.Translator;
import mall.data.dictionary.service.domain.Order;
import mall.data.dictionary.service.infrastructure.mysql.entity.OrderPO;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class OrderTranslator implements Translator<Order, OrderPO> {

    @Override
    public OrderPO forward(Order order) {
        return null;
    }

    @Override
    public Order backward(OrderPO a) {
        return null;
    }
}
