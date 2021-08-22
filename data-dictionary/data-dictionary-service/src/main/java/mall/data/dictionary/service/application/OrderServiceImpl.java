package mall.data.dictionary.service.application;

import lombok.RequiredArgsConstructor;
import mall.data.dictionary.service.api.OrderService;
import mall.data.dictionary.service.api.dto.OrderGetParams;
import mall.data.dictionary.service.api.dto.OrderInfo;
import mall.data.dictionary.service.application.assembler.OrderAssembler;
import mall.data.dictionary.service.domain.Order;
import mall.data.dictionary.service.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author walter
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderAssembler orderAssembler;

    @Override
    public OrderInfo get(OrderGetParams orderGetParams) {
        Order order = this.orderRepository.get(orderGetParams.getId());
        return this.orderAssembler.assemble(order);
    }

}
