package dmall.ddd.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
@Component
public class EventHandlerDispatcher implements BeanFactoryAware, InitializingBean {

    private BeanFactory beanFactory;
    private final Map<String, EventHandler<?>> handles = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public <T extends Event<T>> void handle(T event) {
        EventHandler<T> handler = (EventHandler<T>)this.handles.get(event.getType());
        if (handler == null) {
            throw new RuntimeException("No handler found for event type " + event.getType());
        } else {
            handler.handle(event);
        }
    }

    public void addHandler(EventHandler<?> handler) {
        this.handles.put(handler.getEventType(), handler);
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
        if (beanFactory instanceof ListableBeanFactory) {
            ((ListableBeanFactory) beanFactory).getBeansOfType(EventHandler.class)
                    .values()
                    .forEach(this::addHandler);
        }
    }
}
