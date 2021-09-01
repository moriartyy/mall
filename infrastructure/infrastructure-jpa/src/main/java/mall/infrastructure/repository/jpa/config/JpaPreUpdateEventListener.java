package mall.infrastructure.repository.jpa.config;

import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

/**
 * @author walter
 */
public class JpaPreUpdateEventListener implements PreUpdateEventListener {

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        return false;
    }
}
