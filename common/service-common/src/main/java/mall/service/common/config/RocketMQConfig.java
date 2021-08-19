package mall.service.common.config;

import mall.service.common.infrastructure.rocketmq.RocketMQPublisher;
import mall.service.common.infrastructure.rocketmq.RocketMQSubscriber;
import mall.service.common.util.JsonUtils;
import mall.service.common.util.StringUtils;
import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;


/**
 * @author walter
 */
@AutoConfigureAfter({RocketMQAutoConfiguration.class})
@Configuration
public class RocketMQConfig {

    @Bean
    public RocketMQPublisher rocketMQPublisher(RocketMQTemplate rocketMQTemplate) {
        return new RocketMQPublisher(rocketMQTemplate);
    }

    @Bean
    public RocketMQSubscriber rocketMQSubscriber(RocketMQMessageConverter rocketMQMessageConverter,
                                                 StandardEnvironment environment,
                                                 RocketMQProperties rocketMQProperties) {
        return new RocketMQSubscriber(rocketMQMessageConverter, environment, rocketMQProperties);
    }

    @Bean
    public RocketMQMessageConverter rocketMQMessageConverter() {
        return new RocketMQMessageConverterWithDateTimeModule();
    }

    public static class RocketMQMessageConverterWithDateTimeModule extends RocketMQMessageConverter {

        RocketMQMessageConverterWithDateTimeModule() {
            ((CompositeMessageConverter) this.getMessageConverter()).getConverters()
                    .stream()
                    .filter(c -> c.getClass().equals(MappingJackson2MessageConverter.class))
                    .findFirst()
                    .map(c -> (MappingJackson2MessageConverter) c)
                    .ifPresent(c -> c.getObjectMapper().registerModule(JsonUtils.createDateTimeModule()));
        }

    }

    @Bean
    public static RocketMQPropertiesBeanPostProcessor rocketMQPropertiesBeanPostProcessor() {
        return new RocketMQPropertiesBeanPostProcessor();
    }

    public static class RocketMQPropertiesBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof RocketMQProperties) {
                RocketMQProperties.Producer producer = ((RocketMQProperties) bean).getProducer();
                String group = producer.getGroup();
                if (StringUtils.hasText(group)) {
                    producer.setGroup(StringUtils.lowerHyphenToUpperUnderscore(producer.getGroup()));
                }
            }
            return bean;
        }

    }

}

