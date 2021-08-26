package mall.order.service.application.assembler;

import mall.order.service.api.dto.OrderInfo;
import mall.order.service.domain.Order;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class OrderAssembler {

    public OrderInfo assemble(Order order) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderInfo.getId());
        return orderInfo;
    }
}
