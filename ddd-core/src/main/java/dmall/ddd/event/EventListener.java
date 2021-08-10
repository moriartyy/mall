package dmall.ddd.event;

/**
 * @author walter
 */
public interface EventListener<T extends Event<T>> {

    void onEvent(T event);
}
