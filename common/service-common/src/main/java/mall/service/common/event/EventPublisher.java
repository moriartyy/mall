package mall.service.common.event;

import mall.contract.common.event.Event;

/**
 * @author walter
 */
public interface EventPublisher {

    <T extends Event> void publish(T event);

    <T extends Event> void publishInTraction(T event);
}
