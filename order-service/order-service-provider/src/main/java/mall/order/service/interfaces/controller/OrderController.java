package mall.order.service.interfaces.controller;

import lombok.RequiredArgsConstructor;
import mall.order.service.dto.*;
import mall.order.service.service.OrderService;
import mall.service.dto.PageInfo;
import mall.web.service.annotation.RequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author walter
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class OrderController implements OrderService {

    private final OrderService orderService;

    @Override
    public OrderInfo create(OrderCreateParams orderCreateParams) {
        return this.orderService.create(orderCreateParams);
    }

    @Override
    public OrderInfo update(OrderUpdateParams orderUpdateParams) {
        return this.orderService.update(orderUpdateParams);
    }

    @Override
    public OrderInfo get(@RequestParams OrderGetParams orderGetParams) {
        return orderService.get(orderGetParams);
    }

    @Override
    public PageInfo<OrderInfo> query(OrderQueryParams orderQueryParams) {
        return this.orderService.query(orderQueryParams);
    }

    @Override
    public void delete(OrderDeleteParams orderDeleteParams) {
        this.orderService.delete(orderDeleteParams);
    }

}
