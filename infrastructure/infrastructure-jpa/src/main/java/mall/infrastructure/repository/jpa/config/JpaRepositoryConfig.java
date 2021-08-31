package mall.infrastructure.repository.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * @author walter
 */
@Configuration
public class JpaRepositoryConfig {

    @Bean
    public JpaEventListenerConfigurer jpaEventListenerConfigurer(EntityManagerFactory emf) {
        return new JpaEventListenerConfigurer(emf);
    }
}
