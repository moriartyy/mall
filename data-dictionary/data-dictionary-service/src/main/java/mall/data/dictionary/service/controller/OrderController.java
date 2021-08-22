package mall.data.dictionary.service.controller;

import lombok.RequiredArgsConstructor;
import mall.data.dictionary.service.api.OrderService;
import mall.data.dictionary.service.api.dto.OrderGetParams;
import mall.data.dictionary.service.api.dto.OrderInfo;
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
