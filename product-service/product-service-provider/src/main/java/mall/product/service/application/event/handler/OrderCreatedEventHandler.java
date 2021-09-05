package mall.product.service.application.event.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mall.core.eventing.EventHandler;
import mall.order.service.event.OrderCreatedEvent;
import mall.product.service.application.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderCreatedEventHandler implements EventHandler<OrderCreatedEvent> {

    private final MessageManager messageManager;

    @Override
    public void handle(OrderCreatedEvent event) {
        log.info("Received event: {}", event);
        messageManager.offer(event);
    }
}
