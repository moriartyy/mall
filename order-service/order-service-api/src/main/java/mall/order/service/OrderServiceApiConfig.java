package mall.order.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@EnableFeignClients(basePackages = "mall.order.service")
@Configuration
public class OrderServiceApiConfig {
}
