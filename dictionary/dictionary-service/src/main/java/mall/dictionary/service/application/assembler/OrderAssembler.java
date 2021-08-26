package mall.dictionary.service.application.assembler;

import mall.dictionary.service.api.dto.OrderInfo;
import mall.dictionary.service.domain.Order;
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
