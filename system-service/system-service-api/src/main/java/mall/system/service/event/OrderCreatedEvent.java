package mall.system.service.event;

import lombok.Getter;
import mall.service.event.Event;

/**
 * @author walter
 */
@Getter
public class OrderCreatedEvent extends Event {
    public static final String TOPIC = "order_created_event";

    private Integer orderId;
    private Integer orderAmount;

    public OrderCreatedEvent(Integer orderId, Integer orderAmount) {
        super(true);
        this.orderId = orderId;
        this.orderAmount = orderAmount;
    }

    private OrderCreatedEvent() {
        super(false);
    }
}
