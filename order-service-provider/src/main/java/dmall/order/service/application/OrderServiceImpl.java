package dmall.order.service.application;

import dmall.order.service.contract.OrderService;
import dmall.order.service.contract.dto.OrderGetParams;
import dmall.order.service.contract.dto.OrderInfo;
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
