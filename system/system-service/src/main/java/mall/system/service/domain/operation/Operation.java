package mall.system.service.domain.operation;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.core.domain.AuditableEntity;

import javax.persistence.Entity;

/**
 * @author Walter
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Operation extends AuditableEntity<Integer> {
    private String name;
    private String code;
    private String description;

}
