package mall.order.service.application;

import lombok.RequiredArgsConstructor;
import mall.order.service.application.assembler.OrderAssembler;
import mall.order.service.domain.Order;
import mall.order.service.domain.OrderRepository;
import mall.order.service.dto.*;
import mall.order.service.service.OrderService;
import mall.service.domain.query.PageQuery;
import mall.service.domain.query.PageQueryResult;
import mall.service.domain.query.QueryHelper;
import mall.service.dto.PageInfo;
import mall.service.util.ObjectUtils;
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
        PageQuery<Order> query = QueryHelper.toPageQuery(orderQueryParams);
        PageQueryResult<Order> queryResult = this.orderRepository.findAll(query);
        PageInfo<OrderInfo> pageInfo = new PageInfo<>();
        pageInfo.setTotalItems(queryResult.getTotalItems());
        pageInfo.setPageSize(query.getPageSize());
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
