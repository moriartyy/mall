package mall.product.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@MapperScan("mall.product.service.infrastructure.mysql")
@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProductServiceApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
