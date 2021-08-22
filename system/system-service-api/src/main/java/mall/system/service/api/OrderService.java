package mall.system.service.api;

import mall.system.service.api.dto.OrderGetParams;
import mall.system.service.api.dto.OrderInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface OrderService {

    @RequestMapping(path = "orderMgmt/order/get")
    OrderInfo get(OrderGetParams orderGetParams);
}
