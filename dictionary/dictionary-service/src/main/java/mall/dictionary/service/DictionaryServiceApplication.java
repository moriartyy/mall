package mall.dictionary.service;

import mall.core.bootstrap.Application;
import mall.dictionary.api.DictionaryApiConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@MapperScan("mall.dictionary.service.mapper")
@SpringBootApplication(exclude = DictionaryApiConfig.class)
public class DictionaryServiceApplication {

    public static void main(String[] args) {
        Application.run(DictionaryServiceApplication.class, args);
    }
}
