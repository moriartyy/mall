package mall.core.eventing;

import mall.common.model.Event;

/**
 * @author walter
 */
public interface EventPublisher {

    <T extends Event> void publish(T event);

    <T extends Event> void publishInTraction(T event);
}
