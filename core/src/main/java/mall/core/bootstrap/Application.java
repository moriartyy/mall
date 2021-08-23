package mall.core.bootstrap;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author walter
 */
public class Application {

    private final Class<?>[] primarySources;

    public Application(Class<?>... primarySources) {
        this.primarySources = primarySources;
    }

    public ConfigurableApplicationContext run(String... args) {
        SpringApplication app = new SpringApplication(primarySources);
        app.setBannerMode(Banner.Mode.OFF);
        return app.run(args);
    }

    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return (new Application(primarySource)).run(args);
    }

    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        return (new Application(primarySources)).run(args);
    }
}
