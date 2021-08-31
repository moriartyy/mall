package mall.infrastructure.repository.jpa.config;

import mall.core.context.Context;
import mall.core.domain.AuditableEntity;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

import java.time.LocalDateTime;

/**
 * @author walter
 */
public class JpaPreInsertEventListener implements PreInsertEventListener {

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        if (event.getEntity() instanceof AuditableEntity) {
            AuditableEntity<?> auditableEntity = (AuditableEntity<?>) event.getEntity();
            auditableEntity.setCreatedAt(LocalDateTime.now());
            auditableEntity.setCreatedBy(Context.getCurrent().getUser().getName());
            auditableEntity.setUpdatedAt(auditableEntity.getUpdatedAt());
            auditableEntity.setUpdatedBy(auditableEntity.getCreatedBy());
        }
        return false;
    }
}
