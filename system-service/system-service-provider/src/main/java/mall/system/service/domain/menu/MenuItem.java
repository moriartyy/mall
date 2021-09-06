package mall.system.service.domain.menu;

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
public class MenuItem extends AuditableEntity<Integer> {
    private String name;
    private Integer parentId;
    private Integer resourceId;

}
