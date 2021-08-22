package mall.data.dictionary.service.api;

import mall.data.dictionary.service.api.dto.OrderGetParams;
import mall.data.dictionary.service.api.dto.OrderInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface OrderService {

    @RequestMapping(path = "orderMgmt/order/get")
    OrderInfo get(OrderGetParams orderGetParams);
}
