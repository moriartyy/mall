package mall.system.ui;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walter
 */
@SpringBootApplication
public class SystemUIApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemUIApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
