package mall.order.service.interfaces.controller;

import lombok.RequiredArgsConstructor;
import mall.order.service.contract.OrderService;
import mall.order.service.contract.dto.OrderGetParams;
import mall.order.service.contract.dto.OrderInfo;
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
    public OrderInfo get(@RequestParams OrderGetParams orderGetParams) {
        return orderService.get(orderGetParams);
    }

}
