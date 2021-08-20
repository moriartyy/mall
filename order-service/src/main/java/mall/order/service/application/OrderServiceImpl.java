package mall.order.service.application;

import mall.order.service.api.OrderService;
import mall.order.service.api.dto.OrderGetParams;
import mall.order.service.api.dto.OrderInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderInfo get(OrderGetParams orderGetParams) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderGetParams.getId());
        orderInfo.setAmount(100);
        orderInfo.setBuyer("tom");
        orderInfo.setWhenPlaced(LocalDateTime.now());


        return orderInfo;
    }

}
