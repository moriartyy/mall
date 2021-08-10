package dmall.ddd.event;

/**
 * @author walter
 */
public interface TransactionalEventPublisher {
    <T extends Event<T>> void publish(T event);
}
