package mall.infrastructure.repository.jpa.config;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.springframework.beans.factory.InitializingBean;

import javax.persistence.EntityManagerFactory;

/**
 * @author walter
 */
public class JpaEventListenerConfigurer implements InitializingBean {
    private final EntityManagerFactory emf;

    public JpaEventListenerConfigurer(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void afterPropertiesSet() {
        SessionFactoryImplementor sessionFactory = emf.unwrap(SessionFactoryImplementor.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.prependListeners(EventType.PRE_INSERT, new JpaPreInsertEventListener());
        registry.prependListeners(EventType.PRE_UPDATE, new JpaPreUpdateEventListener());
    }
}
