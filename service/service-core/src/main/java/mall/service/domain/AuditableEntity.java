package mall.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.service.context.Context;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author walter
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AuditableEntity<ID extends Serializable> extends Entity<ID> {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    @PrePersist
    public void beforeInsert() {
        this.createdAt = LocalDateTime.now();
        this.createdBy = Context.getCurrent().getUser().getName();
        this.updatedAt = this.createdAt;
        this.updatedBy = this.createdBy;
    }

    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = Context.getCurrent().getUser().getName();
    }
}
