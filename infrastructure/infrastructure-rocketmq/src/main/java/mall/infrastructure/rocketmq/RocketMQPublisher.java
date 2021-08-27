package mall.infrastructure.rocketmq;

import lombok.RequiredArgsConstructor;
import mall.common.event.Event;
import mall.core.eventing.EventPublisher;
import mall.core.util.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RocketMQPublisher implements EventPublisher {

    private final RocketMQTemplate rocketMQTemplate;

    @Override
    public <T extends Event> void publish(T event) {
        rocketMQTemplate.syncSend(resolveTopic(event), event);
    }

    @Override
    public <T extends Event> void publishInTraction(T event) {
        Message<T> message = MessageBuilder.withPayload(event).build();
        rocketMQTemplate.sendMessageInTransaction(resolveTopic(event), message, null);
    }

    private <T extends Event> String resolveTopic(T event) {
        return StringUtils.upperCamelToUpperUnderscore(event.getClass().getSimpleName());
    }

}
