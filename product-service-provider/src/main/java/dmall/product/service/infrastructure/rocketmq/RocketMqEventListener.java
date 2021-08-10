package dmall.product.service.infrastructure.rocketmq;

import dmall.ddd.event.Event;
import dmall.ddd.event.EventHandlerDispatcher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RocketMqEventListener {
    private final EventHandlerDispatcher eventHandlerDispatcher;

    public void onEvent(Event event) {
        this.eventHandlerDispatcher.handle(event);
    }
}
