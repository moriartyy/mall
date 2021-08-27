package mall.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author walter
 */
@Getter
@Setter
public class AuditableEntity<ID extends Serializable> extends Entity<ID> {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
