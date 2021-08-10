package dmall.ddd.event;

/**
 * @author walter
 */
public interface EventHandler<T extends Event<T>> {

    void handle(T event);

    default String getEventType() {
        return EventUtils.resolveEventType(getClass());
    }
}
