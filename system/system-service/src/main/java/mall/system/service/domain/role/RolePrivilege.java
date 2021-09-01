package mall.system.service.domain.role;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Walter
 */
@Getter
@Setter
public class RolePrivilege {

    private Integer roleId;
    private Integer privilegeId;
    private String privilegeCode;

}
