package mall.system.service.domain.resouce;

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
public class Resource extends AuditableEntity<Integer> {
    private String name;
    private String code;
    private String description;
    private String route;
    private Integer moduleId;

}
