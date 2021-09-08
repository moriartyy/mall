package mall.series.service;

import mall.service.bootstrap.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author walter
 */
@MapperScan("mall.series.service.infrastructure.mapper")
@EnableFeignClients
@SpringBootApplication
public class SeriesServiceApplication {

    public static void main(String[] args) {
        new Application(SeriesServiceApplication.class).run(args);
    }

}
