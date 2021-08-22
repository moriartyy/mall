package mall.system.service.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@EnableFeignClients(basePackages = "mall.order.service.api")
@Configuration
public class OrderServiceApiConfig {
}
