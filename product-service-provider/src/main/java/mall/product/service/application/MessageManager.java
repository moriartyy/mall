package mall.product.service.application;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author walter
 */
@Component
public class MessageManager {

    private final LinkedBlockingQueue<Object> messageQueue = new LinkedBlockingQueue<>();

    public Object take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Object poll() {
        return messageQueue.poll();
    }

    public void offer(Object object) {
        messageQueue.offer(object);
    }
}
