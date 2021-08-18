package dmall.service.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author walter
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig implements EnvironmentAware {

    private Environment environment;

    @Bean
    @ConditionalOnMissingBean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).enable(true)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(environment.getProperty("spring.application.name", "unknown-service") + " Api Doc")
//                .description("XX项目接口文档项目描述")
//                .contact(new Contact("作者", "作者URL", "作者Email"))
                .version("1.0")
                .build();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
