package dmall.service.event;

import dmall.service.contract.event.Event;
import dmall.service.util.ClassUtils;

/**
 * @author walter
 */
public interface EventHandler<T extends Event> {

    void handle(T event);

    default Class<T> getEventType() {
        return ClassUtils.resolveGenericType(getClass());
    }
}
