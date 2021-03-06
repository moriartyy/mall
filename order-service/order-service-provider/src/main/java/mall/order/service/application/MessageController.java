package mall.order.service.application;

import lombok.RequiredArgsConstructor;
import mall.order.service.event.OrderCreatedEvent;
import mall.service.eventing.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageController {

    private final EventPublisher eventPublisher;

    @RequestMapping(path = "message/send")
    public Object sendMessage() {
        OrderCreatedEvent e = new OrderCreatedEvent(10, 100);
        eventPublisher.publish(e);
        return e;
    }
}
