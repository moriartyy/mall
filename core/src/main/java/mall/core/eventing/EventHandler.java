package mall.core.eventing;

import mall.common.model.Event;
import mall.core.util.ClassUtils;

/**
 * @author walter
 */
public interface EventHandler<T extends Event> {

    void handle(T event);

    default Class<T> getEventType() {
        return ClassUtils.resolveGenericType(getClass());
    }
}
