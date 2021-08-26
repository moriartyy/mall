package mall.dictionary.service.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@EnableFeignClients(basePackages = "mall.dictionary.service.api")
@Configuration
public class DictionaryServiceApiConfig {
}
