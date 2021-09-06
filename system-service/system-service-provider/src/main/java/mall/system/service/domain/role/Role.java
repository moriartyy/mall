package mall.system.service.domain.role;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.service.domain.AuditableEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Walter
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Role extends AuditableEntity<Integer> {

    private String name;
    private String description;
    @ElementCollection
    private List<RolePrivilege> privileges = new ArrayList<>();
}
