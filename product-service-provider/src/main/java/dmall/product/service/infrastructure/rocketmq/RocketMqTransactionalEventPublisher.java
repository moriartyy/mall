package dmall.product.service.infrastructure.rocketmq;


import dmall.ddd.event.TransactionalEventPublisher;
import dmall.ddd.event.Event;

/**
 * @author walter
 */
public class RocketMqTransactionalEventPublisher implements TransactionalEventPublisher {

    @Override
    public void publish(Event event) {

    }
}
