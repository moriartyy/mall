package mall.system.service.domain.role;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author Walter
 */
@Getter
@Setter
@Embeddable
public class RolePrivilege {

    private Integer privilegeId;
    private String privilegeCode;

}
