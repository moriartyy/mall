package mall.service.eventing;

import mall.service.event.Event;
import mall.service.util.ClassUtils;

/**
 * @author walter
 */
public interface EventHandler<T extends Event> {

    void handle(T event);

    default Class<T> getEventType() {
        return ClassUtils.resolveGenericType(getClass());
    }
}
