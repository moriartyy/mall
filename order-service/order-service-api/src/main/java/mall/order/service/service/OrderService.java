package mall.order.service.service;

import mall.order.service.dto.*;
import mall.service.dto.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
@FeignClient(name = "order-service")
public interface OrderService {

    @RequestMapping(path = "order/create")
    OrderInfo create(OrderCreateParams orderCreateParams);

    @RequestMapping(path = "order/update")
    OrderInfo update(OrderUpdateParams orderUpdateParams);

    @RequestMapping(path = "order/get")
    OrderInfo get(OrderGetParams orderGetParams);

    @RequestMapping(path = "order/query")
    PageInfo<OrderInfo> query(OrderQueryParams orderQueryParams);

    @RequestMapping(path = "order/delete")
    void delete(OrderDeleteParams orderDeleteParams);
}
