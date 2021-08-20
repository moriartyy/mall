package mall.service.common.config;

import mall.service.common.util.JsonUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author walter
 */
@Configuration
public class ApiConfig implements WebMvcConfigurer, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer dateTimeMapperBuilderCustomizer() {
        return builder -> {
            JsonUtils.addDateTimeSerializers(builder::serializerByType);
            JsonUtils.addDateTimeDeserializers(builder::deserializerByType);
        };
    }

    @Bean
    public RequestParamsArgumentResolver requestParamsArgumentResolver(List<HttpMessageConverter<?>> converters) {
        return new RequestParamsArgumentResolver(converters);
    }

    @Bean
    public ApiResponseBodyAdvice apiResponseBodyAdvice() {
        return new ApiResponseBodyAdvice();
    }

    @Bean
    public ApiExceptionHandler apiExceptionHandler() {
        return new ApiExceptionHandler();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
//                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(beanFactory.getBean(RequestParamsArgumentResolver.class));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
