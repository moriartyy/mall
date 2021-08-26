package mall.system.service;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@SpringBootApplication
public class SystemServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemServiceApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
