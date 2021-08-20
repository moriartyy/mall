package mall.web.service.config;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import mall.web.service.api.result.ApiError;
import mall.web.service.api.result.ApiResult;
import mall.web.service.api.result.ApiStatus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;

import java.util.Collections;
import java.util.List;

/**
 * @author walter
 */
@Configuration
public class SwaggerConfig implements EnvironmentAware, WebMvcConfigurer {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Docket docket(TypeResolver typeResolver) {
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .globalResponses(HttpMethod.GET, getGlobalResponses())
                .globalResponses(HttpMethod.POST, getGlobalResponses())
                .genericModelSubstitutes(ApiResult.class)
//                .additionalModels(typeResolver.resolve(ApiResultModel.class))
                ;

    }

    @Getter
    @ApiModel("ApiResult")
    public static class ApiResultModel<T> {
        @ApiModelProperty(value = "Status", dataType = "int", position = 0)
        private ApiStatus status;
        @ApiModelProperty(value = "Message", position = 1)
        private String message;
        @ApiModelProperty(value = "Data", position = 2)
        private T data;
        @ApiModelProperty(value = "Error", position = 3)
        private ApiError error;
    }

    private List<Response> getGlobalResponses() {
        return Collections.emptyList();
    }

    @Bean
    public ApiInfo apiInfo() {
        String appName = environment.getProperty("spring.application.name", "unknown-service");
        return new ApiInfoBuilder()
                .title(appName.toUpperCase() + " Api Doc")
//                .description("XX项目接口文档项目描述")
//                .contact(new Contact("作者", "作者URL", "作者Email"))
                .version("1.0")
                .build();
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        try {
//            Field registrationsField = FieldUtils.getField(InterceptorRegistry.class, "registrations", true);
//            List<InterceptorRegistration> registrations = (List<InterceptorRegistration>) ReflectionUtils.getField(registrationsField, registry);
//            if (registrations != null) {
//                for (InterceptorRegistration interceptorRegistration : registrations) {
//                    interceptorRegistration
//                            .excludePathPatterns("/swagger**/**")
//                            .excludePathPatterns("/webjars/**")
//                            .excludePathPatterns("/v3/**")
//                            .excludePathPatterns("/doc.html");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Bean
    public static HandlerMethodResolverPostProcessor handlerMethodResolverPostProcessor(TypeResolver typeResolver) {
        return new HandlerMethodResolverPostProcessor(typeResolver);
    }

    public static class HandlerMethodResolverPostProcessor implements BeanPostProcessor {

        private final TypeResolver typeResolver;

        HandlerMethodResolverPostProcessor(TypeResolver typeResolver) {
            this.typeResolver = typeResolver;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof HandlerMethodResolver) {
                return new MyHandlerMethodResolver(typeResolver);
            }
            return bean;
        }
    }

    public static class MyHandlerMethodResolver extends HandlerMethodResolver {

        private final TypeResolver typeResolver;

        public MyHandlerMethodResolver(TypeResolver typeResolver) {
            super(typeResolver);
            this.typeResolver = typeResolver;
        }

        @Override
        public ResolvedType methodReturnType(HandlerMethod handlerMethod) {
            ResolvedType returnType = super.methodReturnType(handlerMethod);
            if (returnType.getErasedType() != ApiResult.class) {
                return typeResolver.resolve(ApiResult.class, returnType);
            }
            return returnType;
        }
    }

}
