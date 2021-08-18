package dmall.product.service.application.event.handler;

import dmall.order.service.contract.event.OrderCreatedEvent;
import dmall.product.service.application.MessageManager;
import dmall.service.event.EventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
