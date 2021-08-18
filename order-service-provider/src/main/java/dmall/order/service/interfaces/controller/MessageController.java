package dmall.order.service.interfaces.controller;

import dmall.order.service.contract.event.OrderCreatedEvent;
import dmall.service.event.EventPublisher;
import lombok.RequiredArgsConstructor;
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
