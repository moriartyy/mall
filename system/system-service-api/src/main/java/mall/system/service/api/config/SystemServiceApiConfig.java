package mall.system.service.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@EnableFeignClients(basePackages = "mall.system.service.api")
@Configuration
public class SystemServiceApiConfig {
}
