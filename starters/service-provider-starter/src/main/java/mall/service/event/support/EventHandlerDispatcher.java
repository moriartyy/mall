package mall.service.event.support;

import mall.service.contract.event.Event;
import mall.service.event.EventHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
@Component
public class EventHandlerDispatcher implements BeanFactoryAware, InitializingBean {

    private BeanFactory beanFactory;
    private final Map<Class<?>, EventHandler<?>> handles = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public <T extends Event> void handle(T event) {
        EventHandler<T> handler = (EventHandler<T>) this.handles.get(event.getClass());
        if (handler == null) {
            throw new RuntimeException("No handler found for event type " + event.getClass());
        } else {
            handler.handle(event);
        }
    }

    public void addHandler(EventHandler<? extends Event> handler) {
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
