package mall.infrastructure.repository.jpa.config;

import mall.core.context.Context;
import mall.core.domain.AuditableEntity;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import java.time.LocalDateTime;

/**
 * @author walter
 */
public class JpaPreUpdateEventListener implements PreUpdateEventListener {

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        if (event.getEntity() instanceof AuditableEntity) {
            AuditableEntity<?> auditableEntity = (AuditableEntity<?>) event.getEntity();
            auditableEntity.setUpdatedAt(LocalDateTime.now());
            auditableEntity.setUpdatedBy(Context.getCurrent().getUser().getName());
        }
        return false;
    }
}
