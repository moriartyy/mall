package mall.data.dictionary.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@MapperScan("mall.data.dictionary.service.infrastructure.mysql.mapper")
@SpringBootApplication
public class DataDictionaryServiceApplication {

    public static void main(String[] args) {
//        new Application(DataDictionaryServiceApplication.class).run(args);
        SpringApplication app = new SpringApplication(DataDictionaryServiceApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
