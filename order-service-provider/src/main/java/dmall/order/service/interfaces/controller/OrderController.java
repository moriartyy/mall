package dmall.order.service.interfaces.controller;

import dmall.order.service.contract.OrderService;
import dmall.order.service.contract.dto.OrderGetParams;
import dmall.order.service.contract.dto.OrderInfo;
import dmall.service.config.RequestParams;
import lombok.RequiredArgsConstructor;
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
