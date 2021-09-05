package mall.dictionary.service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@EnableFeignClients(basePackages = "mall.dictionary.service")
@Configuration
public class DictionaryServiceApiConfig {
}
