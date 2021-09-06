package mall.system.service.domain.module;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.service.domain.AuditableEntity;

import javax.persistence.Entity;

/**
 * @author Walter
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Module extends AuditableEntity<Integer> {
    private String name;
    private String code;
    private String description;
}
