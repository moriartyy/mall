package mall.infrastructure.repository.jpa.domain.rocketmq;

import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;
import mall.common.event.Event;
import mall.common.util.JsonUtils;
import mall.core.eventing.EventHandler;
import mall.core.eventing.EventSubscriber;
import mall.core.util.ClassUtils;
import mall.core.util.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.support.DefaultRocketMQListenerContainer;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author walter
 */
@Slf4j
@Component
public class RocketMQSubscriber implements EventSubscriber, ApplicationContextAware, InitializingBean {


    private ApplicationContext applicationContext;

    private final AtomicLong counter = new AtomicLong(0);

    private final StandardEnvironment environment;

    private final RocketMQProperties rocketMQProperties;

    private final RocketMQMessageConverter rocketMQMessageConverter;

    public RocketMQSubscriber(RocketMQMessageConverter rocketMQMessageConverter,
                              StandardEnvironment environment,
                              RocketMQProperties rocketMQProperties) {
        this.rocketMQMessageConverter = rocketMQMessageConverter;
        this.environment = environment;
        this.rocketMQProperties = rocketMQProperties;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, Object> beans = this.applicationContext.getBeansOfType(EventHandler.class)
                .entrySet().stream().filter(entry -> !ScopedProxyUtils.isScopedTarget(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        beans.forEach(this::registerContainer);
    }

    @SuppressWarnings("unchecked")
    private void registerContainer(String beanName, Object bean) {
        Class<?> handlerClass = AopProxyUtils.ultimateTargetClass(bean);
        Class<? extends Event> eventClass = ClassUtils.resolveGenericType(handlerClass);
        String topic = StringUtils.upperCamelToUpperUnderscore(eventClass.getSimpleName());
        String appName = Optional.ofNullable(this.environment.getProperty("spring.application.name")).orElse("unknown-app");
        String consumerGroup = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, appName);

        boolean listenerEnabled =
                (boolean) rocketMQProperties.getConsumer().getListeners().getOrDefault(consumerGroup, Collections.EMPTY_MAP)
                        .getOrDefault(topic, true);

        if (!listenerEnabled) {
            log.debug(
                    "Consumer Listener (group:{},topic:{}) is not enabled by configuration, will ignore initialization.",
                    consumerGroup, topic);
            return;
        }

        String containerBeanName = String.format("%s_%s", DefaultRocketMQListenerContainer.class.getName(),
                counter.incrementAndGet());
        GenericApplicationContext genericApplicationContext = (GenericApplicationContext) applicationContext;

        genericApplicationContext.registerBean(containerBeanName, DefaultRocketMQListenerContainer.class, () -> {
            DefaultRocketMQListenerContainer container = new DefaultRocketMQListenerContainer();
            container.setRocketMQMessageListener(DefaultRocketMQMessageListenerProvider.LISTENER);
            container.setNameServer(rocketMQProperties.getNameServer());
            container.setTopic(topic);
            container.setConsumerGroup(consumerGroup);
            container.setRocketMQListener((RocketMQListener<String>) payload -> ((EventHandler) bean).handle(JsonUtils.deserializeFromString(payload, eventClass)));
            container.setMessageConverter(rocketMQMessageConverter.getMessageConverter());
            container.setName(containerBeanName);
            return container;
        });

        DefaultRocketMQListenerContainer container = genericApplicationContext.getBean(containerBeanName, DefaultRocketMQListenerContainer.class);
        if (!container.isRunning()) {
            try {
                container.start();
            } catch (Exception e) {
                log.error("Started container failed. {}", container, e);
                throw new RuntimeException(e);
            }
        }

        log.info("Register the listener to container, listenerBeanName:{}, containerBeanName:{}", beanName, containerBeanName);
    }

    @RocketMQMessageListener(consumerGroup = "", topic = "")
    private static class DefaultRocketMQMessageListenerProvider {

        public static final RocketMQMessageListener LISTENER = DefaultRocketMQMessageListenerProvider.class.getAnnotation(RocketMQMessageListener.class);

    }

}
