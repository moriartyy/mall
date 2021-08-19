package mall.service.common.event;

import mall.contract.common.event.Event;
import mall.service.common.util.ClassUtils;

/**
 * @author walter
 */
public interface EventHandler<T extends Event> {

    void handle(T event);

    default Class<T> getEventType() {
        return ClassUtils.resolveGenericType(getClass());
    }
}
