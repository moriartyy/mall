package mall.order.service.contract;

import mall.order.service.contract.dto.OrderGetParams;
import mall.order.service.contract.dto.OrderInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface OrderService {

    @RequestMapping(path = "orderMgmt/order/get")
    OrderInfo get(OrderGetParams orderGetParams);
}
