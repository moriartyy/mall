package mall.data.dictionary.service.application;

import lombok.RequiredArgsConstructor;
import mall.common.model.PageInfo;
import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResolvingService;
import mall.core.domain.query.QueryResult;
import mall.core.util.ObjectUtils;
import mall.data.dictionary.service.api.OrderService;
import mall.data.dictionary.service.api.dto.*;
import mall.data.dictionary.service.application.assembler.OrderAssembler;
import mall.data.dictionary.service.domain.Order;
import mall.data.dictionary.service.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author walter
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderAssembler orderAssembler;
    private final QueryResolvingService queryResolvingService;

    @Override
    public OrderInfo create(OrderCreateParams orderCreateParams) {
        Order order = ObjectUtils.createInstanceOf(Order.class, orderCreateParams);
        this.orderRepository.save(order);
        return this.orderAssembler.assemble(order);
    }

    @Override
    public OrderInfo update(OrderUpdateParams orderUpdateParams) {
        Order order = ObjectUtils.createInstanceOf(Order.class, orderUpdateParams);
        this.orderRepository.save(order);
        return this.orderAssembler.assemble(order);
    }

    @Override
    public OrderInfo get(OrderGetParams orderGetParams) {
        Order order = this.orderRepository.get(orderGetParams.getId());
        return this.orderAssembler.assemble(order);
    }

    @Override
    public PageInfo<OrderInfo> query(OrderQueryParams orderQueryParams) {
        Query query = queryResolvingService.resolve(orderQueryParams);
        QueryResult<Order> queryResult = this.orderRepository.execute(query);
        PageInfo<OrderInfo> pageInfo = new PageInfo<>();
        pageInfo.setTotalItems(queryResult.getTotal());
        pageInfo.setPageSize(query.getLimit());
        pageInfo.setItems(
                queryResult.getItems()
                        .stream().map(this.orderAssembler::assemble)
                        .collect(Collectors.toList()));
        return pageInfo;
    }

    @Override
    public void delete(OrderDeleteParams orderDeleteParams) {
        this.orderRepository.delete(orderDeleteParams.getId());
    }

}
