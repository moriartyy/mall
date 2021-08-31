package mall.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author walter
 */
@Getter
@Setter
@MappedSuperclass
public class AuditableEntity<ID> extends Entity<ID> {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
