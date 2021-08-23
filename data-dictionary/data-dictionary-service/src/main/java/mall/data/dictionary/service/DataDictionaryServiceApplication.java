package mall.data.dictionary.service;

import mall.core.bootstrap.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@MapperScan("mall.data.dictionary.service.infrastructure.mysql.mapper")
@SpringBootApplication
public class DataDictionaryServiceApplication {

    public static void main(String[] args) {
        Application.run(DataDictionaryServiceApplication.class, args);
    }
}
