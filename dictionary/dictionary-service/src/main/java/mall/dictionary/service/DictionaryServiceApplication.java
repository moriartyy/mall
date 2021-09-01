package mall.dictionary.service;

import mall.core.bootstrap.Application;
import mall.dictionary.service.config.DictionaryServiceApiConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@MapperScan("mall.dictionary.service.infrastructure.mapper")
@SpringBootApplication(exclude = DictionaryServiceApiConfig.class)
public class DictionaryServiceApplication {

    public static void main(String[] args) {
        Application.run(DictionaryServiceApplication.class, args);
    }
}
